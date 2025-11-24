package com.company.sso.services;

import com.company.sso.dao.UserDAO;
import com.company.sso.dtos.CreateUserRequest;
import com.company.sso.exceptions.AppException;
import javax.inject.Inject;
import javax.enterprise.context.RequestScoped;
import com.company.sso.models.User;
import com.company.sso.utils.PasswordUtils;
import java.util.List;

@RequestScoped
public class UserService {
    @Inject
    private UserDAO userDAO;

    @Inject
    private TenantService tenantService;

    public User createUser(CreateUserRequest req) {
        String tenantId = req.getTenantId();
        String role = req.getRole();
        if (!tenantService.isValidTenant(tenantId)) {
            throw new AppException("Invalid tenant", 404);
        }

        if (!tenantService.isValidRole(role)) {
            throw new AppException("Invalid tenant", 404);
        }

        List<String> apps = tenantService.getValidApps(tenantId);

        User user = new User(
                req.getEmail(),
                req.getFname(),
                req.getLname(),
                PasswordUtils.hashPassword(req.getPassword()),
                tenantId,
                role,
                apps
        );
        userDAO.create(user);
        return user;
    }
}