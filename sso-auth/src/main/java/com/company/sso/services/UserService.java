package com.company.sso.services;

import com.company.sso.dao.UserDAO;
import com.company.sso.dtos.CreateUserRequest;
import com.company.sso.exceptions.AppException;
import javax.inject.Inject;
import javax.enterprise.context.RequestScoped;
import com.company.sso.models.User;
import com.company.sso.utils.PasswordUtils;
import java.util.Map;

@RequestScoped
public class UserService {
    @Inject
    private UserDAO userDAO;

    @Inject
    private TenantService tenantService;

    public User createUser(CreateUserRequest req) {
        if (!tenantService.isValidTenant(req.getTenantId())) {
            throw new AppException("Invalid tenant", 404);
        }

        if (!tenantService.isValidRole(req.getRole())) {
            throw new AppException("Invalid tenant", 404);
        }

        Map<String, String> apps = tenantService.getValidApps(req.getTenantId());

        User user = new User(
                req.getEmail(),
                req.getFname(),
                req.getLname(),
                PasswordUtils.hashPassword(req.getPassword()),
                req.getTenantId(),
                req.getRole(),
                apps
        );
        userDAO.create(user);
        return user;
    }
}