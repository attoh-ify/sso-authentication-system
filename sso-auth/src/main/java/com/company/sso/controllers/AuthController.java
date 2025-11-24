package com.company.sso.controllers;

import com.company.sso.dtos.LoginRequest;
import com.company.sso.dtos.LoginResponse;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.company.sso.models.SessionToken;
import com.company.sso.services.AuthService;
import com.company.sso.services.TokenService;

@Path("/sso/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {
    @Inject
    private AuthService authService;

    @Inject
    private TokenService tokenService;

    @POST
    @Path("/login")
    public Response login(LoginRequest request) {
        LoginResponse loginResponse = authService.login(request);
        return Response.ok(loginResponse).build();
    }

    @POST
    @Path("/logout")
    public Response logout(@HeaderParam("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring("Bearer ".length());
            tokenService.deleteToken(token);
        }
        return Response.ok("{\"status\":\"SUCCESS\",\"message\":\"Token valid\"}").build();
    }
}