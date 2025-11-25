package com.company.sso.controllers;

import com.company.sso.dao.UserDAO;
import com.company.sso.dtos.CreateUserRequest;
import com.company.sso.dtos.UserResponse;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.company.sso.exceptions.NotFoundException;
import com.company.sso.models.User;
import com.company.sso.services.UserService;

import java.util.ArrayList;
import java.util.List;

@Path("/sso/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserController {
    @Inject
    private UserService userService;

    @Inject
    private UserDAO userDAO;

    @POST
    public Response createUser(CreateUserRequest request) {
        User user = userService.createUser(request);
        UserResponse response = new UserResponse(user);
        return Response.ok(response).build();
    }

    @Path("/{email}")
    @GET
    public Response getUser(@PathParam("email") String email) {
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return Response.ok(new UserResponse(user)).build();
    }

    @Path("/")
    @GET
    public Response getAllUsers() {
        List<User> users = userDAO.findAllUsers();
        if (users == null) {
            throw new NotFoundException("User not found");
        }
        List<UserResponse> user_responses = new ArrayList<>();
        for (User user: users) {
            user_responses.add(new UserResponse(user));
        }
        return Response.ok(user_responses).build();
    }
}