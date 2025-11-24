package com.company.sso.models;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Constants {
    public static final List<String> TENANTS = Arrays.asList(
            "govtest",
            "comp1",
            "comp2"
    );

    public static final List<String> ROLES = Arrays.asList(
            "USER",
            "ADMIN"
    );

    public static final List<String> APPS = Arrays.asList(
            "ecms",
            "emcc",
            "rms",
            "ims",
            "conferencing",
            "govmail"
    );

    public static final Map<String, List<String>> TENANT_APPS = Map.of(
            "govtest", List.of(APPS.get(5), APPS.get(4)),
            "comp1", List.of(APPS.get(0), APPS.get(1), APPS.get(2)),
            "comp2", List.of(APPS.get(5), APPS.get(3))
    );
}