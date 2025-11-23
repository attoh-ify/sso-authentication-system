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
    private String token = UUID.randomUUID().toString();

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

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private List<String> roles;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_apps", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "app")
    private List<String> apps;

    @Column(nullable = false)
    private boolean isActive = false;

    @Column(nullable = false)
    private LocalDateTime createdTime = LocalDateTime.now();

    public User() {}

    public User(String email, String fname, String lname, String passwordHash,
                String tenantId, List<String> roles, List<String> apps) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.passwordHash = passwordHash;
        this.tenantId = tenantId;
        this.roles = roles;
        this.apps = apps;
        this.isActive = true;
        this.createdTime = LocalDateTime.now();
    }
}