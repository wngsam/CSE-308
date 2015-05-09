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
public class Actor {
    private int id;
    private String firstName;
    private String lastName;
    private GregorianCalendar birthDate;
    private String imdb;
    private String picture;

    public int getActorId() {
        return id;
    }

    public void setActorId(int actorId) {
        this.id = actorId;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }
    
}
