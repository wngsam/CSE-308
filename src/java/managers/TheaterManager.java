/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Theater;
import java.util.HashMap;

/**
 *
 * @author Sam W.
 */
public class TheaterManager {
    
    private HashMap<String,Theater> theaters;
    
    public TheaterManager(){
        theaters = new HashMap();
    }
    
    public void createTestTheaters(){
        Theater theaterOne = new Theater();
        Theater theaterTwo = new Theater();
        Theater theaterThree = new Theater();
        theaters.put(theaterOne.getName(), theaterOne);
        theaters.put(theaterTwo.getName(), theaterTwo);
        theaters.put(theaterThree.getName(), theaterThree);
    }

    public HashMap<String, Theater> getTheaters() {
        return theaters;
    }

    public void setTheaters(HashMap<String, Theater> theaters) {
        this.theaters = theaters;
    }
    
    
    
}
