package com.cts.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.cts.*")
public class WebappAngularUdemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebappAngularUdemyApplication.class, args);
	}

}
