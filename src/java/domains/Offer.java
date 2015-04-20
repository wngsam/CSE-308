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
public class Offer {
    private int id;
    private String name;
    private String content;
    private GregorianCalendar expiration;
    private String imageLink;
    
    public Offer(){
        
    }
    
    public Offer(String name, String content, GregorianCalendar expiration) {
        this.name = name;
        this.content = content;
        this.expiration = expiration;
    }

    public int getOfferId() {
        return id;
    }

    public void setOfferId(int id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public GregorianCalendar getExpiration() {
        return expiration;
    }

    public void setExpiration(GregorianCalendar expiration) {
        this.expiration = expiration;
    }  
    
}
