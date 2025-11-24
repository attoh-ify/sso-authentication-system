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

    @Path("/{id}")
    public Response getUser(@PathParam("id") String id) {
        User user = userDAO.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return Response.ok(new UserResponse(user)).build();
    }
}