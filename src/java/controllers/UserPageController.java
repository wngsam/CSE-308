/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.PaymentMethod;
import domains.Transaction;
import domains.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import domains.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import managers.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W.
 */

@Controller
public class UserPageController {
    
    private UserManager userManager;

    @RequestMapping(value="/userpage", method=RequestMethod.GET)
    public ModelAndView viewUserPage(HttpSession session){
        ModelAndView mv = new ModelAndView("userPage");
        mv.addObject("paymentMethod", new PaymentMethod());
                
        mv.addObject("user", session.getAttribute("currentPerson"));
        return mv;
    }
    
    @RequestMapping(value="/editUser" ,method=RequestMethod.POST)
    public ModelAndView editUser(HttpSession session, @ModelAttribute("user") User modifiedUser) throws UnsupportedEncodingException, NoSuchAlgorithmException{
               System.out.println("success UserPageController line 39");
        User user = (User)session.getAttribute("currentPerson");
 
        user.setFirstName(modifiedUser.getFirstName());
        user.setLastName(modifiedUser.getLastName());
        user.setZipCode(modifiedUser.getZipCode());
        user.setBirthDate(modifiedUser.getBirthDate());      
        
        ModelAndView mv = new ModelAndView("userPage");
        userManager.editUser(user);
        mv.addObject("user", session.getAttribute("currentPerson"));
        return mv;
    }
    
    @RequestMapping(value="/edit={creditCardId}", method = RequestMethod.GET)
    public ModelAndView editPayment(HttpSession session, 
            @PathVariable("creditCardId") int creditCardId) {
            
        ModelAndView mv = new ModelAndView("userPage");
        mv.addObject("user", session.getAttribute("currentPerson"));
        mv.addObject("paymentMethod", new PaymentMethod());
                 
        List<PaymentMethod> payments = ((User)session.getAttribute("currentPerson")).getPaymentMethods();
        mv.addObject("payments", payments);
        mv.addObject("edit", "dag");
        
        return mv;
    }
    @RequestMapping(value="/delete={creditCardId}", method = RequestMethod.GET)
    public ModelAndView deletePayment(HttpSession session, 
            @PathVariable("creditCardId") int creditCardId) {
            
        ModelAndView mv = new ModelAndView("userPage");
        mv.addObject("user", session.getAttribute("currentPerson"));
        mv.addObject("paymentMethod", new PaymentMethod());
        
        
        
        List<PaymentMethod> payments = ((User)session.getAttribute("currentPerson")).getPaymentMethods();
        for (PaymentMethod method:payments) {
            if (method.getId() == creditCardId) {
                
                payments.remove(method);
                mv.addObject("payments", payments);
                
                mv.addObject("delete", "dag");
        
                return mv;
            }
        }
        
        
        mv.addObject("payments", payments);
        
        
        
        return mv;
    }
   
    @RequestMapping(value="/userPage", method = RequestMethod.POST)
    public ModelAndView savePayment(
            @ModelAttribute("paymentMethod") PaymentMethod paymentMethod,
            HttpSession session)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        
        ModelAndView mv = new ModelAndView("userPage");
        mv.addObject("user", session.getAttribute("currentPerson"));
        
        List<PaymentMethod> payments = ((User)session.getAttribute("currentPerson")).getPaymentMethods();
        for (PaymentMethod method:payments) {
            if (method.getCreditCardNum() == paymentMethod.getCreditCardNum()) {
                mv.addObject("failure","dang");
                
                mv.addObject("payments", payments);
                return mv;
            }
        }
            
            
            paymentMethod.setId(123);
            ((User)session.getAttribute("currentPerson")).getPaymentMethods().add(paymentMethod);
       
            mv.addObject("Success", "Success");
        
            mv.addObject("payments", payments);
        return mv;
    }
    
    
    public UserManager getUserManager() {
        return userManager;
    }
        
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
}
