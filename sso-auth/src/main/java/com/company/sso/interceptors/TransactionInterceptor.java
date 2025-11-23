package com.company.sso.interceptors;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@TransactionService
@Interceptor
public class TransactionInterceptor {
    @Inject
    private EntityManager em;

    @AroundInvoke
    public Object manageTransaction(InvocationContext ctx) throws Exception {
        EntityTransaction tx = em.getTransaction();

        try {
            if (!tx.isActive()) {
                tx.begin();
            }

            Object result = ctx.proceed();

            if (tx.isActive() && !tx.getRollbackOnly()) {
                tx.commit();
            }

            return result;
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }

            throw e;
        }
    }
}