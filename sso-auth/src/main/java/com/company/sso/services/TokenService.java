package com.company.sso.services;

import com.company.sso.dao.TokenDAO;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import com.company.sso.models.SessionToken;
import com.company.sso.models.User;
import com.company.sso.utils.TimeUtils;

@RequestScoped
public class TokenService {
    @Inject
    private TokenDAO tokenDAO;

    @Inject
    private TimeUtils timeUtils;

    public SessionToken issueToken(User user) {
        SessionToken session = new SessionToken(user, timeUtils.generateExpiry());
        tokenDAO.create(session);
        return session;
    }
}