/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;
import java.util.*;

/**
 *
 * @author DreamRealizer
 */
public class Schedule {
    //SCHEDULE ARE NOW SINGLE SHOWTIMES!
    
    private int id;
    private int movieId;
    private int theaterId;
    private GregorianCalendar showTime;
    private int AMPM;
    private int capacity;

    public String getTime(){
        return showTime.get(Calendar.HOUR)+":00";
    }

    public int getAMPM() {
        return AMPM;
    }

    public void setAMPM(int AMPM) {
        this.AMPM = AMPM;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(int theaterId) {
        this.theaterId = theaterId;
    }

    public GregorianCalendar getShowTime() {
        return showTime;
    }

    public void setShowTime(GregorianCalendar showTime) {
        this.showTime = showTime;
        AMPM = showTime.get(Calendar.AM_PM); //0 = am, 1 = pm
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
