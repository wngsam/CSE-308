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
    private int id;
    private String title;
    private GregorianCalendar releaseDate;
    private int rating;
    private String synopsis;
    private List<Actor> actors;
    private URL poster;
    private Collection<URL> images;
    private boolean recent;
    private double  weekendGross;
    private int numOfTheaters;
    private double theaterAvg;
    private String studio;
    private Collection<String> genre;
    private URL trailer;
    private List<Review> reviews;
    private Map<String,Schedule> schedule; // Map<Theater Name, Schedule>

    public Movie(){
        
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
}
