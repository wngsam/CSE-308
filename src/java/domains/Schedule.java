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
    private int id;
    private int movieId;
    private int theaterId;
    private List<GregorianCalendar> showTime;
    private int capacity;

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

    public List<GregorianCalendar> getShowTime() {
        return showTime;
    }

    public void setShowTime(List<GregorianCalendar> showTime) {
        this.showTime = showTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
