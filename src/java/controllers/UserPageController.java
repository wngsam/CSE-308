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
    
    public UserManager getUserManager() {
        return userManager;
    }
        
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    
}
