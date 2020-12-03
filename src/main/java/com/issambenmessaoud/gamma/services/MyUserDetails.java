package com.issambenmessaoud.gamma.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.issambenmessaoud.gamma.models.EAgentEtat;
import com.issambenmessaoud.gamma.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    private User userl;
    private Long id;

    private String username;

    private String email;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    private String nom;

    public EAgentEtat getEtat() {
        return etat;
    }

    public void setEtat(EAgentEtat etat) {
        this.etat = etat;
    }

    private EAgentEtat etat;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public MyUserDetails(Long id, String username,String nom, String email, String password,
                           Collection<? extends GrantedAuthority> authorities, EAgentEtat etat) {
        this.id = id;
        this.nom = nom ;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.etat = etat;
    }

    public static MyUserDetails build(User user) {
        List<? extends  GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new MyUserDetails(
                user.getId(),
                user.getUsername(),
                user.getNom(),
                user.getEmail(),
                user.getPassword(),
                authorities,
                user.getEtat());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MyUserDetails user = (MyUserDetails) o;
        return Objects.equals(id, user.id);
    }
}
