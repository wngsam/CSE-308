/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import dao.MovieDAO;
import domains.Movie;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Sam W.
 */
public class MovieManager {
    
    private MovieDAO movieDAO;
    private HashMap<String,Movie> movies;
    private ArrayList<Movie> topBoxOffice;
    private ArrayList<Movie> comingSoon;
    private ArrayList<Movie> playingNow;
    private ArrayList<Movie> openingThisWeek;
    
    public MovieManager() throws MalformedURLException {
        movies = new HashMap();
        topBoxOffice = new ArrayList();
        comingSoon = new ArrayList();
        playingNow = new ArrayList();
        openingThisWeek = new ArrayList();
        //createTestcomingSoon();
        //createFakeBoxOffice();
    }
    
    public void updateMovies(){
        movies = new HashMap();
        List<Movie> moviesList = movieDAO.update();
        
        for(Movie m : moviesList){
            movies.put(m.getTitle(),m);
            topBoxOffice.add(m);
            comingSoon.add(m);
        }
        
    }
    
    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
    
    public ArrayList<Movie> getBoxOfficeMovies(){
        return topBoxOffice;
    }
    
    public ArrayList<Movie> getPlayingNowMovies(){
        return playingNow;
    }
    
    public ArrayList<Movie> getComingSoonMovies(){
        return comingSoon;
    }
    
    public ArrayList<Movie> getOpeningThisWeek(){
        return openingThisWeek;
    }

}
