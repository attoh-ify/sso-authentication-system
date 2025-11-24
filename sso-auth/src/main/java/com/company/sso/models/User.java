package com.company.sso.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
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

    @ElementCollection
    @CollectionTable(name="user_apps", joinColumns=@JoinColumn(name="user_id"))
    @Column(name="app")
    private List<String> apps;

    @Column(nullable = false)
    private boolean isActive = false;

    @Column(nullable = false)
    private LocalDateTime createdTime = LocalDateTime.now();

    public User() {}

    public User(String email, String fname, String lname, String passwordHash,
                String tenantId, String role, List<String> apps) {
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

    public String getId() { return id; }

    public String getEmail() { return email; }

    public String getFname() { return fname; }

    public String getLname() { return lname; }

    public String getPasswordHash() { return passwordHash; }

    public String getTenantId() { return tenantId; }

    public String getRole() { return role; }

    public List<String> getApps() { return apps; }

    public boolean isActive() { return isActive; }

    public LocalDateTime getCreatedTime() { return createdTime; }
}