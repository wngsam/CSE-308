/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Movie;
import domains.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import managers.UserManager;
import org.springframework.stereotype.Controller;
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
public class AdminPageController {
    
    private UserManager userManager;
    
    @RequestMapping(value="/adminpage")
    public ModelAndView viewAdminPage(HttpSession session){
        ModelAndView mv = new ModelAndView("adminPage");
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/findmovie", method=RequestMethod.POST)
    public ModelAndView findMovie(@RequestParam(value = "name") String name){
        ModelAndView mv = new ModelAndView("adminEditMovie");
        return mv;
    }
    
    @RequestMapping(value="/editmovie", method=RequestMethod.POST)
    public ModelAndView editMovie(){
        ModelAndView mv = new ModelAndView("adminEditMovie");
        return mv;
    }
    
    @RequestMapping(value="/addmovie", method=RequestMethod.POST)
    public ModelAndView addMovie(){
        ModelAndView mv = new ModelAndView("adminEditMovie");
        return mv;
    }
    
    @RequestMapping(value="/finduser", method=RequestMethod.POST)
    public ModelAndView findUser(@RequestParam(value = "email") String email){
        ModelAndView mv = new ModelAndView("adminEditUser");
        mv.addObject("foundUser", userManager.findUser(email));
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/edituser", method=RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("foundUser") User user){
        ModelAndView mv = new ModelAndView("adminEditUser");
        //edit user info
        mv.addObject("foundUser", user);
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/adduser", method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        ModelAndView mv = new ModelAndView("adminPage");
        user.setRole("User");
        if(!userManager.registerUser(user)){
            mv.addObject("confirmation", false);
        }else{
            mv.addObject("confirmation", true);
        }
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }

}
