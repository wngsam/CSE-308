/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Movie;
import domains.User;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
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
    
    public MovieManager() throws MalformedURLException {
        movies = new HashMap();
        topBoxOffice = new ArrayList();
        comingSoon = new ArrayList();
        playingNow = new ArrayList();
        openingThisWeek = new ArrayList();
        createTestcomingSoon();
    }
    
    public void createTestcomingSoon() throws MalformedURLException{
        
        ArrayList<String> firstGenre = new ArrayList<String>();
        firstGenre.add("Thriller");
        firstGenre.add("Romance");
        Movie comingSoonOne = new Movie(0, "Danny", (GregorianCalendar) GregorianCalendar.getInstance(), 95,
                new URL("http://localhost:8080/samdango/assets/img/danny.jpg"), firstGenre) ;
        
        ArrayList<String> secondGenre = new ArrayList<String>();
        secondGenre.add("Documentary");
        secondGenre.add("History");
        Movie comingSoonTwo = new Movie(0, "Cinderella", (GregorianCalendar) GregorianCalendar.getInstance(), 75,
                new URL("http://localhost:8080/samdango/assets/img/Cinderella.jpg"), secondGenre);
        
        ArrayList<String> thirdGenre = new ArrayList<String>();
        thirdGenre.add("Action/Adventure");
        thirdGenre.add("Health & Fitness");
        Movie comingSoonThree = new Movie(0, "Cupcakes", (GregorianCalendar) GregorianCalendar.getInstance(), 63,
                new URL("http://localhost:8080/samdango/assets/img/cupcakes.jpg"), thirdGenre);
       
        comingSoon.add(comingSoonOne.getId(), comingSoonOne);
        comingSoon.add(comingSoonTwo.getId(), comingSoonTwo);
        comingSoon.add(comingSoonThree.getId(), comingSoonThree);
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
