package com.demo.project;

import java.util.Date;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.project.entity.Person;
import com.demo.project.jdbc.PersonJdbcDao;

@SpringBootApplication
public class UdemyH2databaseDemoApplication implements CommandLineRunner{

	private Logger logger=Logger.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(UdemyH2databaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(dao.findAll());
		logger.info(dao.findById(10003));
		logger.info(dao.deleteById(10002));
		logger.info(dao.insert(new Person(10004, "Tara", "France", new Date())));
		logger.info(dao.update(new Person(10003, "Peter", "Russia", new Date())));
	}

}
