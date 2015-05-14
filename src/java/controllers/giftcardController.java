/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import domains.Email;
import managers.EmailManager;
import managers.GiftCardManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JaeWoong
 */
@Controller
public class giftcardController {
    @Autowired
    private EmailManager emailManager;
    private GiftCardManager giftCardManager;
     
    @RequestMapping(value="/giftcardPage", method=RequestMethod.GET)
    public ModelAndView displayGiftcardPage(){
        ModelAndView mv = new ModelAndView("giftcardPage");
        
        return mv;
    }

    public EmailManager getEmailManager() {
        return emailManager;
    }

    public void setEmailManager(EmailManager emailManager) {
        this.emailManager = emailManager;
    }

    public GiftCardManager getGiftCardManager() {
        return giftCardManager;
    }

    public void setGiftCardManager(GiftCardManager giftCardManager) {
        this.giftCardManager = giftCardManager;
    }
    
    @RequestMapping(value="/personalizingGiftcardPage", method=RequestMethod.POST)
    public ModelAndView displayPersonalizingGiftcardPage(@RequestParam(value = "amount") String amount){
        ModelAndView mv = new ModelAndView("personalizingGiftcardPage");
        System.out.println("33line "+amount);
        int purchaseAmount = Integer.parseInt(amount);
        mv.addObject("purchaseAmount", purchaseAmount);
        return mv;
    }
    
    @RequestMapping(value="giftcardPurchasePage{amount}", method=RequestMethod.GET)
    public ModelAndView displayGiftcardPruchasePage( @RequestParam(value = "email") String email, 
            @RequestParam(value = "message") String message, @RequestParam(value = "title") String title, @PathVariable("amount") String amount){
        ModelAndView mv = new ModelAndView("giftcardPurchasePage");
        System.out.println("43line "+title);
        String emailAddress = email;
        String emailMessage = message;
        String emailTitle = title;
        int buyingAmount = Integer.parseInt(amount);
        mv.addObject("email", emailAddress);
        mv.addObject("message", emailMessage);
        mv.addObject("title", emailTitle);
        mv.addObject("amount", amount);
        return mv;
    } 
    
    @RequestMapping(value="/giftcardSuccess", method=RequestMethod.POST)
    public ModelAndView displayGiftcardSuccess( @RequestParam(value = "email") String email, @RequestParam(value = "message") String message, 
            @RequestParam(value = "title") String title, @RequestParam("amount") String amount, @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName, @RequestParam("creditCardNumber1") String creditCardNumber1, @RequestParam("creditCardNumber2") String creditCardNumber2,
            @RequestParam("creditCardNumber3") String creditCardNumber3, @RequestParam("creditCardNumber4") String creditCardNumber4,
            @RequestParam("ccv") String ccv, @RequestParam("billingAddress") String billingAddress, @RequestParam("zipCode") String  zipCode) throws Exception{
        
        ModelAndView mv = new ModelAndView("giftcardSuccess");
        System.out.println("68line "+title);
        
        String emailMessage = message;
        String emailTitle = title;
        int buyingAmount = Integer.parseInt(amount);
        
        Email newEmail = new Email();
        System.out.print("37" + email);
        String reciver = email; 
        String subject = title;
        String content = message;
         
        newEmail.setReciver(reciver);
        newEmail.setSubject(subject);
        newEmail.setContent(content);
        emailManager.SendEmail(newEmail);
        
        return mv;
    } 
}
