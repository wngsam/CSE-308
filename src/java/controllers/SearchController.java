/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import domains.Movie;
import domains.Theater;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
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
        
       
        String lowercaseSearchParameter = searchParameter.toLowerCase();
        
        Iterator<Movie> m = movieList.iterator();
        Iterator<Theater> t = theaterList.iterator();
        
        while(m.hasNext()){
            Movie movieTemp = m.next();
            String temp = movieTemp.getTitle().toLowerCase();
            String[] splited = temp.split("\\b+"); //split on word boundries
           
            if(Arrays.asList(splited).contains(lowercaseSearchParameter)){
                System.out.println("line49:" + temp );
                continue;
            }
            else{
                System.out.println("53line remove: " + temp+ " , " + movieTemp.getTitle());
                m.remove();
            }       
        }
        
        while(t.hasNext()){
            Theater theaterTemp = t.next();
            String temp = theaterTemp.getName().toLowerCase();
            
            if(temp.contains(lowercaseSearchParameter)){
                System.out.println("line49:" + temp );
                continue;
            }
            else{
                System.out.println("53line remove: " + temp+ " , " + theaterTemp.getName());
                t.remove();
            }       
        }
            
        //for(Movie d: movieList)
          //  System.out.println("66: " + d.getTitle());
        //System.out.println("Size: "+ movieList.size());
        mv.addObject("searchParameter",searchParameter);
        mv.addObject("resultMovieList", movieList);
        mv.addObject("resultTheaterList", theaterList);
        
        return mv;        
    }
    
    @RequestMapping(value="/filterSearch", method = RequestMethod.POST)
    public ModelAndView displayFilterSearch(@RequestParam(value = "genre") String selectedGenre, @RequestParam(value = "searchParameter") String searchParameter){
        
        ModelAndView mv = new ModelAndView("filterSearchResults");
        mv.addObject("searchParameter",searchParameter);
        
        HashMap<String, Movie> movies = movieManager.getMovies();
        List<Movie> movieList = new ArrayList<Movie>(movies.values());
     
        for(Movie d: movieList)
            System.out.println("98: " + d.getTitle());
       
        String lowercaseSearchParameter = searchParameter.toLowerCase();
        Iterator<Movie> m = movieList.iterator();
        
        System.out.println("searchParamter: " + searchParameter);
            
         while(m.hasNext()){
             Movie movieTemp = m.next();
            String temp = movieTemp.getTitle().toLowerCase();
            String[] splited = temp.split("\\b+"); //split on word boundries
           
            if(Arrays.asList(splited).contains(lowercaseSearchParameter)){
                System.out.println("line111:" + temp );
                continue;
            }
            else{
                System.out.println("115line remove: " + temp+ " , " + movieTemp.getTitle());
                m.remove();
            }      
        }
       
         System.out.println("size of movieList: "+movieList.size());
        if(selectedGenre.equals("All")){
              mv.addObject("filteredMovieList", movieList);
              return mv;
        }
        
       
        boolean flag=false;
        
        System.out.println("size of movieList: "+movieList.size());
         Iterator<Movie> m2 = movieList.iterator();
        
        while(m2.hasNext()){
            flag=false;
            Movie movieTemp = m2.next();
            List<String> genreList = movieTemp.getGenres();
            System.out.println("127: "+movieTemp.getTitle());
            for(String s : genreList){
                System.out.println("129: "+s);
                if(selectedGenre.equals(s)){
                    flag=true;
                    break;
                }
            }
                if(flag==false){
                    m2.remove();
                }

        }
        
        System.out.println("139 line filter");
       
       
        mv.addObject("filteredMovieList", movieList);
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
