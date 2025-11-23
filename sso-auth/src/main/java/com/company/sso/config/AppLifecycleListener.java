package com.company.sso.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppLifecycleListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[Auth] Service starting up...");
        System.out.println("Environment: " + System.getProperty("env", "development"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[Auth] Service shutting down...");
    }
}