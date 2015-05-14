/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import domains.Movie;
import domains.Theater;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import managers.MovieManager;
import managers.TheaterManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        HashMap<String, Movie> movies = movieManager.getMovies();
        HashMap<String, Theater> theaters = theaterManager.getTheaters();
        
        List<Movie> movieList = new ArrayList<Movie>(movies.values());
        List<Theater> theaterList = new ArrayList<Theater>(theaters.values());
        
        searchParameter = searchParameter.toLowerCase();
        
        //System.out.println("48line size:" + movies.size());
        for(int i=0; i<movieList.size(); i++){
            String temp = movieList.get(i).getTitle().toLowerCase();
            if(temp.contains(searchParameter))
                continue;
            else
                movieList.remove(i);
        }
        
        for(int i=0; i<theaterList.size(); i++){
            String temp = theaterList.get(i).getName().toLowerCase();
            if(temp.contains(searchParameter))
                continue;
            else
                theaterList.remove(i);
        }
        
        for(Movie m: movieList)
            System.out.println("66: " + m.getTitle());
       
        mv.addObject("resultMovieList", movieList);
        mv.addObject("resultTheaterList", theaterList);
        
        return mv;        
    }
    
    @RequestMapping(value="/filterSearch", method = RequestMethod.POST)
    public ModelAndView displayFilterSearch(@RequestParam(value = "genre") String selectedGenre, @RequestParam(value = "searchParameter") String searchParameter){
        
        ModelAndView mv = new ModelAndView("filterSearchResults");
        
        HashMap<String, Movie> movies = movieManager.getMovies();
       
        List<Movie> movieList = new ArrayList<Movie>(movies.values());
      
        
        searchParameter = searchParameter.toLowerCase();
        
        //System.out.println("48line size:" + movies.size());
        for(int i=0; i<movieList.size(); i++){
            String temp = movieList.get(i).getTitle().toLowerCase();
            if(temp.contains(searchParameter))
                continue;
            else
                movieList.remove(i);
        }
        
        if(selectedGenre.equals("All")){
              mv.addObject("filteredMovieList", movieList);
              return mv;
        }
        
        for (int i = 0; i < movieList.size(); i++) {
            if (movieList.get(i).getGenre().contains(selectedGenre)) {
                continue;
            }
            movieList.remove(i);
        }
        
        mv.addObject("resultMovieList", movieList);
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
