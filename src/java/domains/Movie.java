/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import java.net.URL;
import java.util.*;

/**
 *
 * @author DreamRealizer
 */
public class Movie {
    int id;
    private String title;
    GregorianCalendar releaseDate;
    int rating;
    String synopsis;
    List<Actor> actors;
    URL poster;
    Collection<URL> images;
    boolean recent;
    double  weekendGross;
    int numOfTheaters;
    double theaterAvg;
    String studio;
    Collection<String> genre;
    URL trailer;
    List<Review> reviews;
    Map<String,Schedule> schedule; // Map<Theater Name, Schedule>

    public Movie(){
        
    }
    public Movie(String mtitle) {
        title = mtitle;
        
    }
    public Movie(int id, String title, GregorianCalendar releaseDate, int rating, URL poster, Collection<String> genre){
        this.id=id;
        this.title=title;
        this.releaseDate=releaseDate;
        this.rating = rating;
        this.poster=poster;
        this.genre = genre;
    }
    
    public void setGenre(Collection<String> genre){
        this.genre=genre;
    }
    public Collection<String> setGenre(){
        return this.genre;
    }
    public int getId(){
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
