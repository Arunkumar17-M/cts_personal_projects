package com.cts.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.cts.*"})
@EntityScan(basePackages = {"com.cts.model"})
@EnableJpaRepositories(basePackages = {"com.cts.repository"})
public class TaskOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskOneApplication.class, args);
	}

}
