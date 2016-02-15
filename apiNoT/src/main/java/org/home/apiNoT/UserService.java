package org.home.apiNoT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
private static Map<String, User> users = new HashMap<String, User>();

public List<User> getAllUsers(){
	return new ArrayList<User>(users.values());

	}

public User addUser(String name, int balance){
	users.put(name, new User());
	users.get(name).setName(name);
	users.get(name).setBalance(balance);
	return users.get(name);
	}

public User addBalance(String name, int balance){
	users.get(name).setBalance(balance);
	return users.get(name);
	}
public boolean checkUser(String name){
	if(users.containsKey(name)){
		return true;
		}
	else {
		return false;
		}
	}
public User getUser(String name){
	return users.get(name);
}
}
