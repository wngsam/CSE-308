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
    String title;
    GregorianCalendar releaseDate;
    int rating;
    String synopsis;
    List<Actor> actors;
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
}
