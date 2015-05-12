/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Movie;
import managers.MovieManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JaeWoong
 */
@Controller
public class giftcardController {
    
     private MovieManager movieManager;

/*
     
    @RequestMapping(value="{title}", method = RequestMethod.GET)
    public ModelAndView viewMovieInfo(@PathVariable("title") String movieTitle) {
            
        System.out.println("123456");
        ModelAndView mv = new ModelAndView("movieInfoPage");
        Movie currentMovie = movieManager.getCurrentMovie(movieTitle);
        
        mv.addObject("currentMovie", currentMovie);
       
        return mv;
    }
     
    public MovieManager getMovieManager() {
           return movieManager;
       }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
        movieManager.updateMovies();
    }
    */
    
}
