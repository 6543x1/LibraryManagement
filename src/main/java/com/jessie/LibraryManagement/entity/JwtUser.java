package com.jessie.LibraryManagement.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JwtUser implements UserDetails {
    private static final long serialVersionUID = 1L;

    private int uid;
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean enabled;

    public JwtUser(
            int id,
            String username,
            String password, List<String> authorities,
            boolean enabled
    ) {
        this.uid = id;
        this.username = username;
        this.password = password;
        this.authorities = mapToGrantedAuthorities(authorities);
        this.enabled = enabled;
    }

    public JwtUser(
            int id,
            String username,
            String password, String authoritie,
            boolean enabled
    ) {
        this.uid = id;
        this.username = username;
        this.password = password;
        this.authorities = mapToGrantedAuthorities(authoritie);
        this.enabled = enabled;
    }
    public JwtUser(int id,String username,String password,boolean enabled){
        this.uid=id;
        this.username=username;
        this.password=password;
        this.enabled=enabled;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }


    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "uid='" + uid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", enabled=" + enabled +
                '}';
    }

    private List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }

    private List<GrantedAuthority> mapToGrantedAuthorities(String authoritie) {
        return Arrays.asList(new SimpleGrantedAuthority(authoritie));
    }

    public int getId() {
        return uid;
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
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }



}
