package org.vaadin.example.security;

import com.nimbusds.jose.shaded.gson.Gson;

public class IdToken {
    private String sub;
    private String name;
    private String nickname;
    private String preferred_username;
    private String email;
    private Boolean emailVerified;

    public String toString() {
        return new Gson().toJson(this);
    }
}
