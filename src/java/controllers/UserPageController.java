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
    public ModelAndView editUser(HttpSession session, @ModelAttribute("modifiedUser") User modifiedUser){
        ModelAndView mv = new ModelAndView("userPage");
        mv.addObject("user", session.getAttribute("currentPerson"));
        return mv;
    }
    @RequestMapping(value="/edit={creditCardId}", method = RequestMethod.GET)
    public ModelAndView editPayment(@PathVariable("creditCardId") int creditCardId) {
            
        ModelAndView mv = new ModelAndView("userPage");
        
        mv.addObject("success", "Success");
        
        return mv;
    }
   
   // @RequestMapping(method = RequestMethod.POST) 
    @RequestMapping(value="/userPage", method = RequestMethod.POST)
    public ModelAndView savePayment(
            @ModelAttribute("paymentMethod") PaymentMethod paymentMethod,
            HttpSession session)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {

        ((User)session.getAttribute("currentPerson")).getPaymentMethods().add(paymentMethod);
       
        ModelAndView mv = new ModelAndView("/userPage");
        
        List<PaymentMethod> payments = ((User)session.getAttribute("currentPerson")).getPaymentMethods();
        if (!payments.contains(paymentMethod)) {
            paymentMethod.setId(123);
            
            payments.add(paymentMethod);
            mv.addObject("Success", "Success");
        }
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
