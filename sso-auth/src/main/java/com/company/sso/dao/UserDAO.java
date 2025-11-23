package com.company.sso.dao;

import com.company.sso.models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserDAO {
    @PersistenceContext(unitName = "SSOUnit")
    private EntityManager em;

    public void create(User user) {
        em.persist(user);
    }

    public User update(User user) {
        return em.merge(user);
    }

    public User findById(String id) {
        return em.find(User.class, id);
    }

    public User findByEmail(String email) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.email = :email", User.class
        );
        query.setParameter("email", email);
        List<User> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public User findByTenant(String tenantId) {
        TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.tenantId = :tenantId", User.class
        );
        query.setParameter("tenantId", tenantId);
        List<User> result = query.getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public void delete(User user) {
        if (!em.contains(user)) {
            user = em.merge(user);
        }
        em.remove(user);
    }
}