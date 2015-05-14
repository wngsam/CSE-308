/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import dao.MovieDAO;
import domains.Movie;
import domains.Review;
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
    
    public MovieManager() {
        movies = new HashMap();
        topBoxOffice = new ArrayList();
        comingSoon = new ArrayList();
        playingNow = new ArrayList();
        openingThisWeek = new ArrayList();
    }
    
    public MovieDAO getMovieDAO() {
        return movieDAO;
    }

    public void setMovieDAO(MovieDAO movieDAO) {
        this.movieDAO = movieDAO;
    }
    
    public boolean star(Movie movie){
        return movieDAO.star(movie);
    }
    
    public boolean comment(Review comment){
        
        return movieDAO.writeComment(comment);
    }
    
    public boolean remComment(Review comment){
        return movieDAO.deleteComment(comment);
    }
    
    public Movie findMovie(String name){
        return movies.get(name);
    }
    
    public boolean adminEditMovie(Movie modifiedMovie, String title){
        boolean confirmation = false;
        Movie movie = movies.get(title);
        if(movie!=null){
            movie.setTitle(modifiedMovie.getTitle());
            //release date
            movie.setRating(modifiedMovie.getRating());
            movie.setSynopsis(modifiedMovie.getSynopsis());
            movie.setPoster(modifiedMovie.getPoster());
            movie.setWeekendGross(modifiedMovie.getWeekendGross());
            movie.setNumOfTheaters(modifiedMovie.getNumOfTheaters());
            movie.setTheaterAverage(modifiedMovie.getTheaterAverage());
            movie.setTrailer(modifiedMovie.getTrailer());
            movie.setStars(modifiedMovie.getStars());
            confirmation = movieDAO.adminEditMovie(movie);
            if(confirmation==true){
                movies.remove(title);
                movies.put(movie.getTitle(),movie);
            }
        }
        return confirmation;
    }
    
    public boolean adminDelMovie(String name){
        boolean confirmation = false;
        if(movies.get(name)!=null){
            if(movieDAO.adminDelMovie(movies.get(name).getId())){
                movies.remove(name);
                confirmation = true;
            }
        }
        return confirmation;
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
    
    public boolean addMovie(Movie movie){
        boolean confirmation = false;
        if(movies.get(movie.getTitle())==null){
            if(movieDAO.adminAddMovie(movie)==true){
                movies.put(movie.getTitle(),movie);
                confirmation = true;
            }
        }
        
        return confirmation;
    }
    
    public Movie getCurrentMovie(String movieTitle){
        return movies.get(movieTitle);
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

    public HashMap<String, Movie> getMovies() {
        return movies;
    }

    public void setMovies(HashMap<String, Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getTopBoxOffice() {
        return topBoxOffice;
    }

    public void setTopBoxOffice(ArrayList<Movie> topBoxOffice) {
        this.topBoxOffice = topBoxOffice;
    }

    public ArrayList<Movie> getComingSoon() {
        return comingSoon;
    }

    public void setComingSoon(ArrayList<Movie> comingSoon) {
        this.comingSoon = comingSoon;
    }

    public ArrayList<Movie> getPlayingNow() {
        return playingNow;
    }

    public void setPlayingNow(ArrayList<Movie> playingNow) {
        this.playingNow = playingNow;
    }

}
