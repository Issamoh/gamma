package com.issambenmessaoud.gamma.models.payloads;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class LoginResponse {

    final private  String jwt;
    final private  long id ;
    final private  String username;
    final private  String email ;
    final private  String nom;

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public LoginResponse(String jwt, long id, String username, String email, String nom, Collection<? extends GrantedAuthority> roles) {
        this.jwt = jwt;
        this.id = id;
        this.username = username;
        this.email = email;
        this.nom = nom;
        this.roles = roles;
    }

    private Collection<? extends GrantedAuthority> roles;


    public String getJwt() {
        return jwt;
    }
}
