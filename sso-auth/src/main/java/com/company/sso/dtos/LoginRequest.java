package com.company.sso.dtos;

public class LoginRequest {
    private String email;
    private String password;
    private String tenantId;

    public LoginRequest() {}

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }
}