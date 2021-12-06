package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	public Film findFilmById(int filmId);

	public Film addNewFilm(Film film);

	public Film updateFilm(Film film);
	
	public boolean deleteFilm(Film film);

	public List<Film> findFilmsByKeyword(String keyword);

	public List<Actor> findActorsByFilmId(int filmId);

	public String findCategoryByFilmId(int filmId);

}
