package com.company.sso.dtos;

import com.company.sso.models.User;

import java.time.LocalDateTime;
import java.util.List;

public class UserResponse {
    private String email;
    private String fname;
    private String lname;
    private String tenantId;
    private boolean isActive;
    private String role;
    private List<String> apps;
    private LocalDateTime createdTime;

    public UserResponse(User user) {
        this.email = user.getEmail();
        this.fname = user.getFname();
        this.lname = user.getLname();
        this.tenantId = user.getTenantId();
        this.isActive = user.isActive();
        this.role = user.getRole();
        this.apps = user.getApps();
        this.createdTime = user.getCreatedTime();
    }

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getTenantId() {
        return tenantId;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getRole() {
        return role;
    }

    public List<String> getApps() {
        return apps;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}