package org.vaadin.example.security;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.openid.ClaimsDefinition;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@OpenIdAuthenticationMechanismDefinition(
        clientId = "${oidcConfig.clientId}",
        clientSecret = "${oidcConfig.clientSecret}",
        redirectURI = "${baseURL}/callback",
        providerURI = "${oidcConfig.issuerUri}",
        jwksConnectTimeout = 5000,
        jwksReadTimeout = 5000,
        extraParameters = {"audience=https://dev-g2jrapmlm450fvvk.eu.auth0.com/api/v2/"},
        claimsDefinition = @ClaimsDefinition(callerGroupsClaim = "http://www.jakartaee.demo/roles")
)
@ApplicationScoped
@Named("oidcConfig")
public class OidcConfig {

    private static final Logger LOGGER = Logger.getLogger(OidcConfig.class.getName());
    private String domain;
    private String clientId;
    private String clientSecret;
    private String issuerUri;

    @PostConstruct
    void init() {
        try {
            var properties = new Properties();
            properties.load(getClass().getResourceAsStream("/oidc.properties"));
            domain = properties.getProperty("domain");
            clientId = properties.getProperty("clientId");
            clientSecret = properties.getProperty("clientSecret");
            issuerUri = "https://" + this.domain + "/";
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to load oidc.properties", e);
        }
    }

    public String getDomain() {
        return domain;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getIssuerUri() {
        return issuerUri;
    }
}
