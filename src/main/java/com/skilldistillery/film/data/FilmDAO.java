package com.skilldistillery.film.data;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	public Film findFilmById(int filmId);

	Film addNewFilm(Film film);

	boolean deleteFilm(Film film);

}
