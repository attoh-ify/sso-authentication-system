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

    public static final Map<String, String> APPS = Map.of(
            "ecms", "http://example.com/ecms/",
            "emcc", "http://example.com/emcc/",
            "rms", "http://example.com/ams/",
            "ims", "http://example.com/ims/",
            "conferencing", "http://example.com/conferencing/",
            "govmail", "http://example.com/govmail/"
    );

    public static final Map<String, List<String>> TENANT_APPS = Map.of(
            "govtest", List.of("govmail", "conferencing"),
            "comp1", List.of("ecms", "emcc", "rms"),
            "comp2", List.of("govmail", "conferencing")
    );
}