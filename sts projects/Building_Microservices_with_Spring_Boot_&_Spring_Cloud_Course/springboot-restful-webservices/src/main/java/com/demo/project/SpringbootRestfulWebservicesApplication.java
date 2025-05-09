package com.demo.project;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
// below is for just for description that will show in swagger ui
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot REST API Documentation",
				description = "Spring Boot REST API Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Arun Kumar",
						email = "Kumar@gmail.com",
						url = "Google.com"
						),
				license = @License(
						name = "Apache 2.0",
						url = "Google.com/license"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Spring Boot REST API Documentation",
				url = "Google.com/user management.html"
				)
		)
public class SpringbootRestfulWebservicesApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRestfulWebservicesApplication.class, args);
	}

}
