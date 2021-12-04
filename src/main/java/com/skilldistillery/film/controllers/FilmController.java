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
	
	  @RequestMapping(path = "GetFilm.do", params = "name", method = RequestMethod.GET)
	  public ModelAndView getFilmById(int filmID) {
	    ModelAndView mv = new ModelAndView();  
	    Film f = filmDAO.findFilmById(filmID);
	    mv.addObject("film", f);
	    mv.setViewName("WEB-INF/SearchByID.jsp");
	    return mv;
	  }
}
