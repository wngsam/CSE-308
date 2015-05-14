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
    private String rating;
    private String synopsis;
    private String poster;
    private double weekendGross;
    private int numOfTheaters;
    private double theaterAverage;
    private String trailer;
    private List<String> genres;
    private List<Actor> cast;
    private List<String> images;
    private List<Review> reviews;
    private double stars;
    private int rates;
    private int starRating;
    private boolean fresh=false;
            
    public Movie(){
        
    }

    public void calculateStarRating(){
        if(rates!=0){
            starRating = (int)(stars/rates);
            if(starRating>5){
                starRating=5;
            }
        }else{
            starRating = 0;
        }
    }
    
    public int getRates() {
        return rates;
    }

    public void setRates(int rates) {
        this.rates = rates;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
        //System.out.println("~~~!!!!! "+reviews.get(0).getTitle());
    }
    
    public void checkFresh(){
        fresh=true; //CHECK IF THE MOVIE IS FRESH BY COMPARING IT TO A CERTAIN DATE
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
        checkFresh();
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = "assets\\img\\"+poster;
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

    public double getTheaterAverage() {
        return theaterAverage;
    }

    public void setTheaterAverage(double theaterAverage) {
        this.theaterAverage = theaterAverage;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = "https://www.youtube.com/embed/" + trailer;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public List<String> getGenre() {
        return genres;
    }

    public void setGenre(List<String> genres) {
        this.genres = genres;
    }

    public List<Actor> getCast() {
        return cast;
    }

    public void setCast(List<Actor> cast) {
        this.cast = cast;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
    
}
