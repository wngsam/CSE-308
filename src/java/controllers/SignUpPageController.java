/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import managers.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W
 */

@Controller
@RequestMapping("/registrationPage")
public class SignUpPageController {
    
    private UserManager userManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView signUp(){
        ModelAndView mv = new ModelAndView("registrationPage");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView doSignUp(@RequestParam("fname") String fname){
        
        ModelAndView mv = new ModelAndView("index");
        
        
        
        return mv;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
}
