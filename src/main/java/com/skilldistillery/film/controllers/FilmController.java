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
	  
	  @RequestMapping(path="AddNewFilm.do", params = {"title", "description", "releaseYear", "languageID", "rentalDuration", "rentalRate", 
			  "length", "replacementCost", "rating", "specialFeatures"}, method = RequestMethod.POST)
	  public ModelAndView addFilm(String title, String description, int releaseYear, int languageID, int rentalDuration, double rentalRate, 
			  int length, double replacementCost, String rating, String specialFeatures) {
		  ModelAndView mv = new ModelAndView();
		  Film film = new Film();
		  //film.set all the objects
		  film.setTitle(title);
		  film.setDescription(description);
		  film.setReleaseYear(releaseYear);
		  film.setLanguageId(languageID);
		  film.setRentalDuration(rentalDuration);
		  film.setRentalRate(rentalRate);
		  film.setLength(length);
		  film.setReplacementCost(replacementCost);
		  film.setRating(rating);
		  film.setSpecialFeatures(specialFeatures);
		  Film f = filmDAO.addNewFilm(film);
		  mv.addObject("film", f);
		  mv.setViewName("AddNewFilm");
		  return mv;
	  }
}
