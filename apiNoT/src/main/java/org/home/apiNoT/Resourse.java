package org.home.apiNoT;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("/balance")
public class Resourse {

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getMessage(@PathParam("username") String username) {
		List<User> list = new ArrayList<User>();
		for (int i = 0; i < User.u.size(); i++) {
			if (User.u.get(i).getName().equalsIgnoreCase(username)) {
				list.add(User.u.get(i));
				break;
			}
		}
		return list;
	}

	@PUT
	@Path("/{username}/{balance}")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getMessage(@PathParam("username") String username, @PathParam("balance") int balance) {
		List<User> list = new ArrayList<User>();
		boolean check = true;
		for (int i = 0; i < User.u.size(); i++) {
			if (User.u.get(i).getName().equalsIgnoreCase(username)) {
				User.u.get(i).setBalance(balance);
				list.add(User.u.get(i));
				check = false;
			}
		}
		if (check == true) {
		User user = new User();
		user.setName(username);
		user.setBalance(balance);
			User.u.add(user);
			for (int i = 0; i < User.u.size(); i++) {
				if (User.u.get(i).getName().equalsIgnoreCase(username)) {
					list.add(User.u.get(i));
				}
			}
		}
		return list;
	}

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsers() {
		return User.u;
	}
	

   
}