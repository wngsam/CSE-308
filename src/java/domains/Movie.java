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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GregorianCalendar getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(GregorianCalendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public URL getPoster() {
        return poster;
    }

    public void setPoster(URL poster) {
        this.poster = poster;
    }

    public Collection<URL> getImages() {
        return images;
    }

    public void setImages(Collection<URL> images) {
        this.images = images;
    }

    public boolean isRecent() {
        return recent;
    }

    public void setRecent(boolean recent) {
        this.recent = recent;
    }

    public double getWeekendGross() {
        return weekendGross;
    }

    public void setWeekendGross(double weekendGross) {
        this.weekendGross = weekendGross;
    }

    public int getNumOfTheaters() {
        return numOfTheaters;
    }

    public void setNumOfTheaters(int numOfTheaters) {
        this.numOfTheaters = numOfTheaters;
    }

    public double getTheaterAvg() {
        return theaterAvg;
    }

    public void setTheaterAvg(double theaterAvg) {
        this.theaterAvg = theaterAvg;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Collection<String> getGenre() {
        return genre;
    }

    public void setGenre(Collection<String> genre) {
        this.genre = genre;
    }

    public URL getTrailer() {
        return trailer;
    }

    public void setTrailer(URL trailer) {
        this.trailer = trailer;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Map<String, Schedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<String, Schedule> schedule) {
        this.schedule = schedule;
    }
    
    
    
    
}
