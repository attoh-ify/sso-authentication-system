package com.company.sso.services;

import javax.enterprise.context.ApplicationScoped;
import com.company.sso.models.Constants;
import java.util.List;

@ApplicationScoped
public class TenantService {
    public boolean isValidTenant(String tenantId) {
        return Constants.TENANTS.contains(tenantId);
    }

    public boolean isValidRole(String role) {
        return Constants.ROLES.contains(role);
    }

    public List<String> getValidApps(String tenantId) {
        return Constants.TENANT_APPS.get(tenantId);
    }
}