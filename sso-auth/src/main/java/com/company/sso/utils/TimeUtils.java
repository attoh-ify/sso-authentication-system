package com.company.sso.utils;

import java.time.LocalDateTime;

public class TimeUtils {
    private TimeUtils() {}

    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static LocalDateTime expiryMinutes(int minutes) {
        return LocalDateTime.now().plusMinutes(minutes);
    }

    public static boolean isExpired(LocalDateTime expiry) {
        return LocalDateTime.now().isAfter(expiry);
    }
}