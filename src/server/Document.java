package server;

import java.util.ArrayList;
import java.util.List;

import model.User;

public class Document {
	private List<User> users;
	private List<User> userslist = populate();

	public Document(){
		users = new ArrayList<User>();
	}
	
	private List<User> populate() {
		List<User> u = new ArrayList<User>();
		u.add(new User(10.101, 10.102));
		u.add(new User(20.201, 20.202));
		u.add(new User(30.301, 30.302));
		u.add(new User(40.401, 40.402));
		u.add(new User(50.501, 50.502));
		return u;
	}

	public void addUser(User u){
		users.add(u);
	}
	
	public void removeUser(User u){
		users.remove(u);
	}
	
	public List<User> getUsers(){
		return users;
	}
	
	public List<User> getUsersList(){
		return userslist;
	}
}
