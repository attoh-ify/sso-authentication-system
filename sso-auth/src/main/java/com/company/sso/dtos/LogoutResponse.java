package com.company.sso.dtos;

import com.company.sso.models.User;
import java.time.LocalDateTime;

public class LogoutResponse {
    private String status;
    private String message;

    public LogoutResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}