package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	public Film findFilmById(int filmId);

	public Film addNewFilm(Film film);

	public Film updateFilm(Film film);
	
	boolean deleteFilm(Film film);

	List<Film> findFilmsByKeyword(String keyword);

	List<Actor> findActorsByFilmId(int filmId);

}
