### Disable `integrated-jaspi` in WildFly 30.0.1.Final

Add the following in domain configuration `standalone.xml` under `subsystem xmlns="urn:jboss:domain:undertow:14.0"`
```
<application-security-domains>
    <application-security-domain name="other" security-domain="ApplicationDomain" enable-jacc="true" integrated-jaspi="false"/>
</application-security-domains>
```
