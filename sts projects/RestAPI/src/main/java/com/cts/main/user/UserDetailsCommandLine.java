package com.cts.main.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLine implements CommandLineRunner {

	public UserDetailsCommandLine(UserDetailsRepository repository) {
		super();
		this.repository = repository;
	}

	private Logger logger = LoggerFactory.getLogger(getClass());

	private UserDetailsRepository repository;

	@Override
	public void run(String... args) throws Exception {

		repository.save(new UserDetails("Arun", "Admin"));
		repository.save(new UserDetails("Eren", "Hacker"));
		repository.save(new UserDetails("Erwin", "Head"));
		
//		List<UserDetails> users = repository.findAll();
		
		List<UserDetails> users = repository.findByRole("Admin");

		users.forEach(user -> logger.info(user.toString()));
	}

}
