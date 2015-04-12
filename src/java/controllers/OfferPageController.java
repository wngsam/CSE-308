/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Offer;
import java.util.List;
import managers.OfferManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Desktop
 */
@Controller
@RequestMapping("/offersPage")
public class OfferPageController {
    
    private OfferManager offerManager;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewOffers(){
        ModelAndView mv = new ModelAndView("offersPage");
        System.out.println(offerManager.getOffers().size());
        List<Offer> offers= offerManager.getOffers();
        mv.addObject("offers", offers);
        return mv;
    }

    public OfferManager getOfferManager() {
        return offerManager;
    }

    public void setOfferManager(OfferManager offerManager) {
        this.offerManager = offerManager;
    }
    
    
    
}
