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
        List<PaymentMethod> payments = ((User)session.getAttribute("currentPerson")).getPaymentMethods();
        
        mv.addObject("paymentMethod", new PaymentMethod());             
        mv.addObject("payments", payments);
        mv.addObject("user", session.getAttribute("currentPerson"));
        return mv;
    }
    
    @RequestMapping(value="/editUser" ,method=RequestMethod.POST)
    public ModelAndView editUser(HttpSession session, @ModelAttribute("user") User modifiedUser) throws UnsupportedEncodingException, NoSuchAlgorithmException{               
        User user = (User)session.getAttribute("currentPerson");
 
        user.setFirstName(modifiedUser.getFirstName());
        user.setLastName(modifiedUser.getLastName());
        user.setZipCode(modifiedUser.getZipCode());
        user.setBirthDate(modifiedUser.getBirthDate());      
        
        ModelAndView mv = new ModelAndView("userPage");
        userManager.editUser(user);
        mv.addObject("user", session.getAttribute("currentPerson"));
        mv.addObject("paymentMethod", new PaymentMethod());  
        return mv;
    }
    
    @RequestMapping(value="/editPassword" ,method=RequestMethod.POST)
    public ModelAndView editPassword(HttpSession session, @RequestParam(value = "currentPwd") String currentPwd, @RequestParam(value = "newPwd") String newPwd, @RequestParam(value = "confirmPwd") String confirmPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException{               
        User user = (User)session.getAttribute("currentPerson"); 
        //Authenticate the user with the current password.        
        user=userManager.authenticate(user.getEmail(), currentPwd);
        ModelAndView mv = new ModelAndView("userPage");
        if(user==null){
            mv.addObject("wrongPwd","WrongPwd");
        }
        else{
            if(newPwd.equals(confirmPwd)){
                userManager.editPassword(user,newPwd);                
            }
            else{                
                mv.addObject("pwdConflict","pwdConflict");
            }
        }
        mv.addObject("paymentMethod", new PaymentMethod());  
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
                userManager.deletePaymentMethod(creditCardId);
                payments.remove(method);
                mv.addObject("payments", payments);
                
                mv.addObject("delete", "Deleted.");
        
                return mv;
            }
        }
        
        //should never come here
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
        boolean invalid = false;
        
        //Payment with same credit card num exists
        for (PaymentMethod method:payments) {
            if (method.getCreditCardNum().equals(paymentMethod.getCreditCardNum())) {
                mv.addObject("failure","Payment method currently exists with the same credit card number.");
                invalid = true;
            }
        }
        
        //Now we check for correct credentials
        if (paymentMethod.getCreditCardNum().length() != 16 || 
                !paymentMethod.getCreditCardNum().matches("[0-9]+")) {
            mv.addObject("CCLengthFailure", "Invalid credit card.");
            invalid = true;
        }
        if (paymentMethod.getCcv().length() != 3 || 
                !paymentMethod.getCcv().matches("[0-9]+")) {
            mv.addObject("InvalidCCV", "Invalid CCV.");
            invalid = true;
        }
        if (paymentMethod.getZipCode().length() != 5 || 
                !paymentMethod.getZipCode().matches("[0-9]+")) {
            mv.addObject("InvalidZipcode", "Invalid Zipcode.");
            invalid = true;
        }
       
            
        //There is something wrong with the payment method.    
        if (invalid) {
            mv.addObject("payments", payments);
            return mv;
        
        }
        
        //Payment is valid!
            User user = ((User)session.getAttribute("currentPerson"));
            paymentMethod.setUserId(user.getId());
            userManager.addPaymentMethod(paymentMethod, user);
            user.getPaymentMethods().add(paymentMethod);
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
