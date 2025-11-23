package com.company.sso.models;

import java.util.Arrays;
import java.util.List;

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
            "ams",
            "ims",
            "conferencing",
            "govmail"
    );
}