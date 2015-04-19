/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Movie;
import java.util.List;
import managers.MovieManager;
import org.springframework.stereotype.Controller;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JaeWoong
 */
@Controller
public class MovieInfoController {
    
     private MovieManager movieManager;

  
       @RequestMapping(value="/movieInfoPage", method=RequestMethod.GET)
        public ModelAndView viewMovieInfo(){
       
            System.out.println("123456");
        ModelAndView mv = new ModelAndView("movieInfoPage");
        Movie currentMovie = movieManager.getCurrentMovie("Danny Collins");
        
        mv.addObject("currentMovie", currentMovie);
        
        System.out.println("jasonshin " + currentMovie.getMovieId() + " "+ currentMovie.getTitle());
      
        return mv;
    }
     
    public MovieManager getMovieManager() {
           return movieManager;
       }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
        movieManager.updateMovies();
    }
    
    
}