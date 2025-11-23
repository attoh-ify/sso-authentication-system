package com.company.sso.utils;

import java.time.LocalDateTime;

public class TimeUtils {
    public TimeUtils() {}

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static LocalDateTime expiryMinutes(int minutes) {
        return LocalDateTime.now().plusMinutes(minutes);
    }

    public static boolean isExpired(LocalDateTime expiry) {
        return LocalDateTime.now().isAfter(expiry);
    }

    public LocalDateTime generateExpiry() {
        return LocalDateTime.now().plusMinutes(24 * 60);
    }
}