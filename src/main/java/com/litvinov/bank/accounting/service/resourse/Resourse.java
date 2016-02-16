package com.litvinov.bank.accounting.service.resourse;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.litvinov.bank.accounting.service.models.User;
import com.litvinov.bank.accounting.service.models.UserService;

@Path("/balance/")
public class Resourse {
	UserService service = new UserService();

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getMessage(@PathParam("username") String username) {
		List<User> list = new ArrayList<User>();
		if (service.checkUser(username)) {
			list.add(service.getUser(username));
		}
		return list;
	}

	@PUT
	@Path("/{username}/{balance}")
	@Produces(MediaType.APPLICATION_XML)
	public User getMessage(@PathParam("username") String username, @PathParam("balance") int balance) {
		if (service.checkUser(username)) {
			service.addBalance(username, balance);
			return service.getUser(username);
		} else {
			service.addUser(username, balance);
			return service.getUser(username);
		}
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return service.getAllUsers();
	}

}