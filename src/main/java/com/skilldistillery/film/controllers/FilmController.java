package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDAO;

	@RequestMapping({ "/", "home.do" })
	public String home(Model model) {
		model.addAttribute("TEST", "Hello, Spring MVC!");
		return "home";
	}
	
	  @RequestMapping(path = "GetFilm.do", params = "filmId", method = RequestMethod.GET)
	  public ModelAndView getFilmById(Integer filmId) {
	    ModelAndView mv = new ModelAndView();  
	    Film f = filmDAO.findFilmById(filmId);
	    mv.addObject("film", f);
	    mv.setViewName("result");
	    return mv;
	  }
	  
	  @RequestMapping(path="SearchByID.do", method = RequestMethod.GET)
	  public ModelAndView searchByIDPage() {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("SearchByID");
		  return mv;
	  }
	  
	  @RequestMapping(path="AddNewFilm.do", method = RequestMethod.GET)
	  public ModelAndView AddNewFilmForm() {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("AddNewFilm");
		  return mv;
	  }
	  
	  @RequestMapping(path="AddNewFilmFormInfo.do", params = {"title", "description", "releaseYear", "languageId", "rentalDuration", "rentalRate", "length", "replacementCost", "rating", "specialFeatures"}, method = RequestMethod.GET)
	  public ModelAndView addFilm(String title, String description, int releaseYear, int languageId, int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
		  ModelAndView mv = new ModelAndView();
		  Film film = new Film();
		  //film.set all the objects
		  film.setTitle(title);
		  film.setDescription(description);
		  film.setReleaseYear(releaseYear);
		  film.setLanguageId(languageId);
		  film.setRentalDuration(rentalDuration);
		  film.setRentalRate(rentalRate);
		  film.setLength(length);
		  film.setReplacementCost(replacementCost);
		  film.setRating(rating);
		  film.setSpecialFeatures(specialFeatures);
		  Film f = filmDAO.addNewFilm(film);
		  mv.addObject("film", f);
//		  if (f != null) {
			  mv.setViewName("filmAddedResult");			  
//		  } else {
//			  mv.setViewName("home");
//		  }
		  return mv;
	  }
	  
	  @RequestMapping(path="SearchByIdToEdit.do", method = RequestMethod.GET)
	  public ModelAndView searchByIdToEdit() {
		  ModelAndView mv = new ModelAndView();
		  mv.setViewName("SearchByIdToEdit");
		  return mv;
	  }
	  
	  @RequestMapping(path = "SearchFilmToEdit.do", params = "filmId", method = RequestMethod.GET)
	  public ModelAndView getFilmInfoToEdit(Integer filmId) {
	    ModelAndView mv = new ModelAndView();  
	    Film f = filmDAO.findFilmById(filmId);
	    mv.addObject("film", f);
	    mv.setViewName("editFilm");
	    return mv;
	  }
	  
	  @RequestMapping(path = "UpdateInfo.do", params = {"id", "title", "description", "releaseYear", "languageId", "rentalDuration", "rentalRate", "length", "replacementCost", "rating", "specialFeatures"}, method = RequestMethod.POST)
	  public ModelAndView editFilm(int id, String title, String description, int releaseYear, int languageId, int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String specialFeatures) {
		  ModelAndView mv = new ModelAndView();  
		  Film film = new Film();
		  film.setId(id);
		  film.setTitle(title);
		  film.setDescription(description);
		  film.setReleaseYear(releaseYear);
		  film.setLanguageId(languageId);
		  film.setRentalDuration(rentalDuration);
		  film.setRentalRate(rentalRate);
		  film.setLength(length);
		  film.setReplacementCost(replacementCost);
		  film.setRating(rating);
		  film.setSpecialFeatures(specialFeatures);
		  Film f = filmDAO.updateFilm(film);
		  mv.addObject("film", f);
		  filmDAO.updateFilm(f);
		  mv.setViewName("result");
		  return mv;
	  }
	  
	  @RequestMapping(path="delete.do", params="filmId", method = RequestMethod.GET)
	  public ModelAndView deleteFilm(int filmId) {
		  ModelAndView mv = new ModelAndView();
		  Film f = filmDAO.findFilmById(filmId);
		  
		  if (filmId > 1000 && f != null) {
			  filmDAO.deleteFilm(f);
			  mv.setViewName("deleteSuccess");
		  } else {
			  mv.setViewName("deleteFailure");
		  }
		  
		  return mv;
	  }
}
