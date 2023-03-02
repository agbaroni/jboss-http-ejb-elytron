package io.github.agbaroni.jhee.services;

import io.github.agbaroni.jhee.business.client.Users;
import io.github.agbaroni.jhee.persistence.User;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UsersService implements Serializable {

    private static final long serialVersionUID = 2205171971981L;

    @EJB
    private Users users;

    @GET
    public List<User> getAll() {
	return users.findAll();
    }

    @POST
    @Path("/{userName}")
    public void create(@PathParam("userName") String userName, User user) {
	user.setUserName(userName);

	users.createUser(user);
    }
}
