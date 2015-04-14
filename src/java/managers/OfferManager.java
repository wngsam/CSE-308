/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Offer;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Sam W.
 */
public class OfferManager {
    
    private List<Offer> offers;
    
    
    public OfferManager(){
        offers = new ArrayList<Offer>();
        createTestOffer();        
    }
    
    public List<Offer> getOffers(){
        System.out.print(offers.get(0).getName());
        return offers;
    }
    
    public void createTestOffer() {
        Offer testOffer = new Offer("Sponge Bob 3D Discount", "Discount 30% for each ticket!", new GregorianCalendar(4,12,2015,11,59));
        Offer testOffer2 = new Offer("Run the Night Discount", "Discount 40% for each ticket!", new GregorianCalendar(4,12,2015,11,59));
        offers.add(testOffer);
        offers.add(testOffer2);
    }
    
}
