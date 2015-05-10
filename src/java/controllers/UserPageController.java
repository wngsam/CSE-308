/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.User;
import javax.servlet.http.HttpSession;
import managers.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
        mv.addObject("user", session.getAttribute("currentPerson"));
        return mv;
    }
    
    @RequestMapping(value="/editUser" ,method=RequestMethod.POST)
    public ModelAndView editUser(HttpSession session, @ModelAttribute("modifiedUser") User modifiedUser){
        ModelAndView mv = new ModelAndView("userPage");
        mv.addObject("user", session.getAttribute("currentPerson"));
        return mv;
    }
    
    public UserManager getUserManager() {
        return userManager;
    }
        
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
}
