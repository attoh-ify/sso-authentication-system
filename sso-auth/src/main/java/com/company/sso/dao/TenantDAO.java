package com.company.sso.dao;

import com.company.sso.models.Constants;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TenantDAO {
    public List<String> getAllTenants() {
        return Constants.TENANTS;
    }

    public boolean exists(String tenantId) {
        return Constants.TENANTS.contains(tenantId);
    }
}