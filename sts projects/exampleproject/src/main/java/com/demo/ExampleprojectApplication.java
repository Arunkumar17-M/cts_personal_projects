package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ExampleprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleprojectApplication.class, args);
	}

}
