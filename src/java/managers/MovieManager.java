/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Movie;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Sam W.
 */
public class MovieManager {
    
    private HashMap<String,Movie> movies;
    private ArrayList<Movie> topBoxOffice;
    private ArrayList<Movie> comingSoon;
    private ArrayList<Movie> playingNow;
    private ArrayList<Movie> openingThisWeek;
    
    public MovieManager(){
        movies = new HashMap();
        topBoxOffice = new ArrayList();
        comingSoon = new ArrayList();
        playingNow = new ArrayList();
        openingThisWeek = new ArrayList();
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
