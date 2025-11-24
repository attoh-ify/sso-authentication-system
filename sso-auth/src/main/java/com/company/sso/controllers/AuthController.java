package com.company.sso.controllers;

import com.company.sso.dao.TokenDAO;
import com.company.sso.dtos.LoginRequest;
import com.company.sso.dtos.LoginResponse;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.company.sso.dtos.LogoutResponse;
import com.company.sso.filters.Secured;
import com.company.sso.services.AuthService;

@Path("/sso/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthController {
    @Inject
    private AuthService authService;

    @Inject
    private TokenDAO tokenDAO;

    @POST
    @Path("/login")
    public Response login(LoginRequest request) {
        LoginResponse loginResponse = authService.login(request);
        return Response.ok(loginResponse).build();
    }

    @POST
    @Path("/logout")
    @Secured
    public Response logout(@HeaderParam("Authorization") String authHeader) {
        LogoutResponse logoutResponse = authService.logout(authHeader);
        return Response.ok(logoutResponse).build();
    }
}