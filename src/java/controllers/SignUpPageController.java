/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import managers.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W.
 */

@Controller
@RequestMapping("/registrationPage")
public class SignUpPageController {
    
    private UserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView signUp(){        
        ModelAndView mv = new ModelAndView("registrationPage");
        mv.addObject("user", new User());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView doSignUp(
            @ModelAttribute("user") User user,
            HttpSession session) 
            throws UnsupportedEncodingException, NoSuchAlgorithmException{
        ModelAndView mv = new ModelAndView("index");
        user.setRole("User");
        
        if(userManager.registerUser(user)==true){
            session.setAttribute("currentPerson", user);
        }else{
            mv = new ModelAndView("registrationPage");
            mv.addObject("confirmation", false);
        }        
        return mv;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
}
