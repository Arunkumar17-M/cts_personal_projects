package com.demo.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.project.model.Film;

public interface FilmRepository extends JpaRepository<Film, Integer> {

	List<Film> findByCustomerId(int id);
	Film findById(int id);

}
