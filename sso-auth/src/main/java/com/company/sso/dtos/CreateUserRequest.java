package com.company.sso.dtos;

public class CreateUserRequest {
    private String email;
    private String fname;
    private String lname;
    private String password;
    private String tenantId;
    private String role;

    public CreateUserRequest() {}

    public String getEmail() {
        return email;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getPassword() {
        return password;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getRole() {
        return role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setRole(String role) {
        this.role = role;
    }
}