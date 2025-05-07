package com.cts.main;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cts.main.user.UserDetails;
import com.cts.main.user.UserDetailsRepository;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

	// My Test to run the application as commandLineRunner

	private static Logger log = LoggerFactory.getLogger(RestApiApplication.class);

	@Bean
	public CommandLineRunner demo(UserDetailsRepository repository) {
		return (args) -> {

			List<UserDetails> users = repository.findAll();

			users.forEach(user -> log.info(user.toString()));

		};
	}

}
