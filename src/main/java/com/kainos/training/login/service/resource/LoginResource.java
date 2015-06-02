package com.kainos.training.login.service.resource;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginResource {
    private final String requiredUsername;
    private final String requiredPassword;

    public LoginResource(String requiredUsername, String requiredPassword) {
        this.requiredUsername = requiredUsername;
        this.requiredPassword = requiredPassword;
    }

    @POST
    public Response sayHello(@FormParam("username") String username,
           @FormParam("password") String password) {
        if(username.equals(requiredUsername) && password.equals(requiredPassword)) {
            return Response.noContent().build();
        }
        throw new WebApplicationException("Invalid user", 401);
    }
}
