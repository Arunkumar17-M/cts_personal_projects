package com.demo.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.project.model.Film;
import com.demo.project.repository.FilmRepository;

@Service
public class FilmService {
	
	@Autowired
	public FilmRepository filmrepo;
	
	public List<Film> listallfilm(int id){
		return filmrepo.findByCustomerId(id);
	}
	
	public Film getSpecificFilm(int filmid) {
		return filmrepo.findById(filmid);
	}
	
	public void save(Film film) {
		filmrepo.save(film);
	}
	
	@Transactional
	public boolean deletefilmbyid(int filmid) {
		if(this.getSpecificFilm(filmid) != null) {
			filmrepo.deleteById(filmid);
			return true;
		}
		
		return false;
	}

}
