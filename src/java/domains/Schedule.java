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
    private String movieName;
    private String theaterName;

    public String getTime(){
        String s = "";
        if(showTime.get(Calendar.HOUR)==0){
            s+="12";
        }else{
            s+="0"+showTime.get(Calendar.HOUR);
        }
        String AP = "";
        if(AMPM==0){
            AP+= "AM";
        }else if(AMPM==1){
            AP+="PM";
        }
        return s+":00 "+AP;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
    
    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
