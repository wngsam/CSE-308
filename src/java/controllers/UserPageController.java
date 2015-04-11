/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpSession;
import managers.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W.
 */
@Controller
@RequestMapping("/userpage")
public class UserPageController {
    
    private UserManager userManager;

    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView viewUserPage(HttpSession session){
        ModelAndView mv = new ModelAndView("userPage");
        
        return mv;
    }
    
    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
    
    
    
}
