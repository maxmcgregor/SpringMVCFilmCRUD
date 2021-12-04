package com.skilldistillery.film.data;

import com.skilldistillery.film.entities.Film;

public interface FilmDAO {

	public Film findFilmById(int filmId);

	public Film addNewFilm(Film film);

	public Film updateFilm(Film film);
}
