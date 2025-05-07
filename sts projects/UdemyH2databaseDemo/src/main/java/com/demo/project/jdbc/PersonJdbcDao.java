package com.demo.project.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.project.entity.Person;

@Repository
public class PersonJdbcDao {
	
	@Autowired
	JdbcTemplate jdbctemplate;

	public List<Person> findAll(){
		return jdbctemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public Person findById(int id) {
		return jdbctemplate.queryForObject("select * from person where id=?", new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class));
	}
	
	public int deleteById(int id) {
		return jdbctemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbctemplate.update(
				"insert into person (id, name, location, birth_date)"
				+ " values(?, ?, ?, ?)",
				new Object[] {person.getId(),person.getName(),person.getLocation(),
						new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person) {
		return jdbctemplate.update(
				"update person"
				+ " set name=?, location=?, birth_date=?"
				+ " where id=?",
				new Object[] {person.getName(),person.getLocation(),
						new Timestamp(person.getBirthDate().getTime()), person.getId()});
	}
}
