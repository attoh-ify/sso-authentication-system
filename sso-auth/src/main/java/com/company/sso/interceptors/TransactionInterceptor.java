package com.company.sso.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@TransactionService
@Interceptor
public class TransactionInterceptor {
    @PersistenceContext(unitName = "SSOUnit")
    private EntityManager em;

    @AroundInvoke
    public Object manageTransaction(InvocationContext ctx) throws Exception {
        try {
            return ctx.proceed();
        } catch (Exception e) {
            throw e;
        }
    }
}