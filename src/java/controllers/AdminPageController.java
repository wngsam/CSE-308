/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.User;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
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
    
    @RequestMapping(value="/adminpage")
    public ModelAndView viewAdminPage(HttpSession session){
        ModelAndView mv = new ModelAndView("adminPage");
        mv.addObject("user", new User());
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
        return mv;
    }
    
    @RequestMapping(value="/edituser", method=RequestMethod.POST)
    public ModelAndView editUser(){
        ModelAndView mv = new ModelAndView("adminEditUser");
        return mv;
    }
    
    @RequestMapping(value="/adduser", method=RequestMethod.POST)
    public ModelAndView addUser(){
        ModelAndView mv = new ModelAndView("adminEditUser");
        return mv;
    }
    
}
