package com.demo.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.project.model.Film;
import com.demo.project.service.FilmService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FilmController {
	
	@Autowired
	public FilmService filmService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping("/user/{userid}/film")
	public List<Film> listallfilm(@PathVariable int userid){
		
		return filmService.listallfilm(userid);
	}
	
	@GetMapping("/user/{userid}/film/{filmid}")
	public Film getSpecificFilm(@PathVariable int filmid) {
		return filmService.getSpecificFilm(filmid);
	}
	
	@PostMapping("user/{userid}/film")
	public ResponseEntity<Void> addfilm(@RequestBody Film film,@PathVariable int userid){
		film.setCustomerId(userid);
		filmService.save(film);
		return ResponseEntity.created(null).build();
	}
	
	@PutMapping("user/{userid}/film/{filmid}")
	public ResponseEntity<Void> updateFilm(@RequestBody Film film, @PathVariable int userid){
		film.setCustomerId(userid);
		filmService.save(film);
		return ResponseEntity.accepted().build();
	}
	
	@DeleteMapping("user/{userid}/film/{filmid}")
	public ResponseEntity<Void> deleteFilm(@PathVariable int filmid){
		if(filmService.deletefilmbyid(filmid))
			return ResponseEntity.ok().build();
		
		return ResponseEntity.notFound().build();
	}
}
