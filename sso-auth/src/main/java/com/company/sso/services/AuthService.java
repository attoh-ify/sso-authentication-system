package com.company.sso.services;

import com.company.sso.dao.TokenDAO;
import com.company.sso.dao.UserDAO;
import com.company.sso.dtos.LoginRequest;
import com.company.sso.dtos.LoginResponse;
import com.company.sso.dtos.LogoutResponse;
import com.company.sso.exceptions.UnauthorizedException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.company.sso.models.SessionToken;
import com.company.sso.models.User;
import com.company.sso.utils.PasswordUtils;

@RequestScoped
public class AuthService {
    @Inject
    private UserDAO userDAO;

    @Inject
    private TokenService tokenService;

    @Inject
    private TokenDAO tokenDAO;

    public LoginResponse login(LoginRequest req) {
        User user = userDAO.findByEmail(req.getEmail());

        if (user == null || !PasswordUtils.verifyPassword(req.getPassword(), user.getPasswordHash())) {
            throw new UnauthorizedException("Invalid email or password");
        }

        SessionToken token = tokenService.issueToken(user);

        return new LoginResponse(
                "SUCCESS",
                token.getToken(),
                token.getExpiry(),
                null,
                user
        );
    }

    public LogoutResponse logout(String authHeader) {
        String token = authHeader.substring("Bearer ".length());
        tokenDAO.deleteToken(token);
        return new LogoutResponse("SUCCESS", "Token valid");
    }
}