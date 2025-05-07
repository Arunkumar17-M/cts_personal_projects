package com.demo.project.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int customerId;

	private String filmName;

	private String filmDuration;

	private int amount;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate releaseDate;

	private boolean isWatched;

	public Film() {
		super();

	}

	public Film(int id, int customerId, String filmName, String filmDuration, int amount, boolean isWatched,
			LocalDate releaseDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.filmName = filmName;
		this.filmDuration = filmDuration;
		this.amount = amount;
		this.isWatched = isWatched;
		this.releaseDate = releaseDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public String getFilmDuration() {
		return filmDuration;
	}

	public void setFilmDuration(String filmDuration) {
		this.filmDuration = filmDuration;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isWatched() {
		return isWatched;
	}

	public void setWatched(boolean isWatched) {
		this.isWatched = isWatched;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", customerId=" + customerId + ", filmName=" + filmName + ", filmDuration="
				+ filmDuration + ", amount=" + amount + ", isWatched=" + isWatched + ", releaseDate=" + releaseDate
				+ "]";
	}

}
