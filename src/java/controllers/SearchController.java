/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Movie;
import domains.Theater;
import java.util.HashMap;
import java.util.List;
import managers.MovieManager;
import managers.TheaterManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W.
 */

@Controller
public class SearchController {
    
    private MovieManager movieManager;
    private TheaterManager theaterManager;
    
    @RequestMapping(value="/searchResults", method = RequestMethod.POST)
    public ModelAndView search(@RequestParam(value = "searchParameter") String searchParameter){
        ModelAndView mv = new ModelAndView("searchResults");
        HashMap<String, Movie> searchedMovies = movieManager.getMovies();
        HashMap<String, Theater> searchedTheaters = theaterManager.getTheaters();
        
        
        return mv;        
    }

    public MovieManager getMovieManager() {        
        return movieManager;
    }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
    }

    public TheaterManager getTheaterManager() {        
        return theaterManager;
    }

    public void setTheaterManager(TheaterManager theaterManager) {
        this.theaterManager = theaterManager;
    }
    
    
    
}
