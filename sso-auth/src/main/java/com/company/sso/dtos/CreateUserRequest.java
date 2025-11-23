package com.company.sso.dtos;

import java.util.List;
import java.util.Map;

public class CreateUserRequest {
    private String email;
    private String fname;
    private String lname;
    private String password;
    private String tenantId;
    private String role;
    private Map<String, String> apps;

    public CreateUserRequest() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Map<String, String> getApps() {
        return apps;
    }

    public void setApps(Map<String, String> apps) {
        this.apps = apps;
    }
}