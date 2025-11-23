package com.company.sso.dtos;

import java.time.LocalDateTime;

public class LoginResponse {
    private String status;
    private String token;
    private LocalDateTime expiry;
    private String twoFactorAuth;
    private UserResponse user;

    public LoginResponse() {}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiry() {
        return expiry;
    }

    public void setExpiry(LocalDateTime expiry) {
        this.expiry = expiry;
    }

    public String getTwoFactorAuth() {
        return twoFactorAuth;
    }

    public void setTwoFactorAuth(String twoFactorAuth) {
        this.twoFactorAuth = twoFactorAuth;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}