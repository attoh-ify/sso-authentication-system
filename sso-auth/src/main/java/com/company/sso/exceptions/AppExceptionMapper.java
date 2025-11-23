package com.company.sso.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.json.Json;
import javax.json.JsonObject;

@Provider
public class AppExceptionMapper implements ExceptionMapper<AppException> {
    @Override
    public Response toResponse(AppException ex) {
        JsonObject payload = Json.createObjectBuilder()
                .add("status", "FAILED")
                .add("message", ex.getMessage())
                .add("code", ex.getStatusCode())
                .build();

        return Response.status(ex.getStatusCode())
                .entity(payload)
                .build();
    }
}