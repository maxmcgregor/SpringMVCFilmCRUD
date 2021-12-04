package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Service;

import com.skilldistillery.film.entities.Film;

@Service
public class FilmDAOJDBCImpl implements FilmDAO {

	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";
	private static final String user = "student";
	private static final String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading mysql driver!");
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = new Film();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmId);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				film.setId(filmResult.getInt("id"));
				film.setTitle(filmResult.getString("title"));
				film.setDescription(filmResult.getString("description"));
				film.setReleaseYear(filmResult.getInt("release_year"));
				film.setLanguageId(filmResult.getInt("language_id"));
				film.setRentalDuration(filmResult.getInt("rental_duration"));
				film.setRentalRate(filmResult.getDouble("rental_rate"));
				film.setLength(filmResult.getInt("length"));
				film.setReplacementCost(filmResult.getDouble("replacement_cost"));
				film.setRating(filmResult.getString("rating"));
				film.setSpecialFeatures(filmResult.getString("special_features"));
//				film.setActors(findActorsByFilmId(filmId));
			} else {
				return null;
			}
			filmResult.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}
	
	@Override
	public Film addNewFilm(Film film) {
		Connection conn = null;
		String user = "student";
		String pass = "student";
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			String sql = "INSERT INTO film (title, description, release_year, language_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());

			int update = stmt.executeUpdate();
			ResultSet keys = stmt.getGeneratedKeys();

			if (keys.next() && update == 1) {
				conn.commit();

				String sql2 = "SELECT * FROM film WHERE id = LAST_INSERT_ID()";
				PreparedStatement stmt2 = conn.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
				ResultSet rs = stmt2.executeQuery();
				if (rs.next()) {
					film.setId(rs.getInt("id"));
//					film.setLanguageId(rs.getInt("language_id"));
//					film.setRentalDuration(rs.getInt("rental_duration"));
//					film.setRentalRate(rs.getDouble("rental_rate"));
//					film.setLength(rs.getInt("length"));
//					film.setReplacementCost(rs.getDouble("replacement_cost"));
//					film.setRating(rs.getString("rating"));
//					film.setSpecialFeatures(rs.getString("special_features"));

					rs.close();
				}

				conn.close();
			} else {
				conn.rollback();
				conn.close();
				System.out.println("Creating film unsuccessful, rolling back...");
				film = null;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;

	}
	
}
