package com.demo.project.resource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int usercount=0;
	static {
		users.add(new User(++usercount, "Adam", LocalDate.now()));
		users.add(new User(++usercount, "Eve", LocalDate.now()));
		users.add(new User(++usercount, "Jim", LocalDate.now()));
	}

	public List<User> findAll() {
		return users;
	}

	public User findOne(int id) {
		return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
	}
	
	public User save(User user) {
		user.setId(++usercount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		users.removeIf(user -> user.getId() == id);
	}
}
