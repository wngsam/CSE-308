/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import managers.MovieManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Desktop
 */
@Controller
public class MovieListController {
    
    private MovieManager movieManager;
    
    @RequestMapping(value="/comingSoonPage", method=RequestMethod.GET)
    public ModelAndView viewComingSoon(){
        ModelAndView mv = new ModelAndView("comingSoonPage");

        return mv;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
    }
    
}
