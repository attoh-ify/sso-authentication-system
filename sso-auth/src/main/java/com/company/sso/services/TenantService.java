package com.company.sso.services;

import javax.enterprise.context.ApplicationScoped;
import com.company.sso.models.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TenantService {
    public List<String> getAllTenants() {
        return Constants.TENANTS;
    }

    public boolean isValidTenant(String tenantId) {
        return Constants.TENANTS.contains(tenantId);
    }

    public boolean isValidRole(String role) {
        return Constants.ROLES.contains(role);
    }

    public Map<String, String> getValidApps(String tenantId) {
        List<String> apps = Constants.TENANT_APPS.get(tenantId);
        Map<String, String> apps_map = new HashMap<String, String>();
        for (String app: apps) {
            if (Constants.APPS.containsKey(app)) {
                apps_map.put(app, Constants.APPS.get(app));
            }
        }
        return apps_map;
    }
}