package com.company.sso.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name="users")
public class User {
    @Id
    @Column(length = 36)
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String fname;

    @Column(nullable = false)
    private String lname;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String tenantId;

    @Column(nullable = false)
    private String role;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_apps", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "url")
    @Column(name = "app")
    private Map<String, String> apps;

    @Column(nullable = false)
    private boolean isActive = false;

    @Column(nullable = false)
    private LocalDateTime createdTime = LocalDateTime.now();

    public User() {}

    public User(String email, String fname, String lname, String passwordHash,
                String tenantId, String role, Map<String, String> apps) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.passwordHash = passwordHash;
        this.tenantId = tenantId;
        this.role = role;
        this.apps = apps;
        this.isActive = true;
        this.createdTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
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

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getRole() {
        return role;
    }

    public Map<String, String> getApps() {
        return apps;
    }

    public boolean isActive() {
        return isActive;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}