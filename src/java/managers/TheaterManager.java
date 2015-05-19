/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import dao.TheaterDAO;
import domains.Theater;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Sam W.
 */
public class TheaterManager {
    
    private HashMap<String,Theater> theaters;
    private TheaterDAO theaterDAO;
    
    public TheaterManager(){
        theaters = new HashMap();
    }

    public TheaterDAO getTheaterDAO() {
        return theaterDAO;
    }

    public void setTheaterDAO(TheaterDAO theaterDAO) {
        this.theaterDAO = theaterDAO;
    }

    public HashMap<String, Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(HashMap<String, Theater> theaters) {
        this.theaters = theaters;
    }
    
    public void updateTheaters(){
        List<Theater> theaterList = theaterDAO.update();
        for(Theater t : theaterList){
            theaters.put(t.getName(),t);
        }
        
    }
    
}
