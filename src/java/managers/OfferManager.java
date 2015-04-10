/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Offer;
import java.util.ArrayList;

/**
 *
 * @author Sam W.
 */
public class OfferManager {
    
    private ArrayList<Offer> offers;
    
    public OfferManager(){
        offers = new ArrayList();
    }
    
    public ArrayList<Offer> getOffers(){
        return offers;
    }
    
}
