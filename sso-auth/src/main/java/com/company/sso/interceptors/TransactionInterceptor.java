//package com.company.sso.interceptors;
//
//import javax.interceptor.AroundInvoke;
//import javax.interceptor.Interceptor;
//import javax.interceptor.InvocationContext;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityTransaction;
//import javax.persistence.PersistenceContext;
//
//@TransactionService
//@Interceptor
//public class TransactionInterceptor {
//    @PersistenceContext(unitName = "SSOUnit")
//    private EntityManager em;
//
//    @AroundInvoke
//    public Object manageTransaction(InvocationContext ctx) throws Exception {
//        EntityTransaction tx = em.getTransaction();
//        try {
//            if (!tx.isActive()) tx.begin();
//
//            Object result = ctx.proceed();
//
//            tx.commit();
//            return result;
//        } catch (Exception e) {
//            if (tx.isActive()) tx.rollback();;
//            throw e;
//        }
//    }
//}