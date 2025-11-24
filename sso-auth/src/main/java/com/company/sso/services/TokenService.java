package com.company.sso.services;

import com.company.sso.dao.TokenDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import com.company.sso.models.SessionToken;
import com.company.sso.utils.TimeUtils;

@RequestScoped
public class TokenService {
    @Inject
    private TokenDAO tokenDAO;

    @Inject
    private TimeUtils timeUtils;

    public SessionToken issueToken(String userId) {
        SessionToken session = new SessionToken(userId, timeUtils.generateExpiry());
        tokenDAO.create(session);
        return session;
    }

    public SessionToken validateToken(String token) {
        return tokenDAO.findByToken(token);
    }

    public void deleteToken(String token) {
        tokenDAO.deleteToken(token);
    }
}