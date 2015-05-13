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
import managers.MovieManager;
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
    private MovieManager movieManager;
    
    @RequestMapping(value="/adminpage")
    public ModelAndView viewAdminPage(HttpSession session){
        ModelAndView mv = new ModelAndView("adminPage");
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/findmovie", method=RequestMethod.POST)
    public ModelAndView findMovie(@RequestParam(value = "name") String name, HttpSession session){
        ModelAndView mv = new ModelAndView("adminEditMovie");
        Movie movie = movieManager.findMovie(name);
        if(movie!=null){
            session.setAttribute("foundMovieName", name);
            mv.addObject("foundMovie", movie);
        }else{
            mv.addObject("nomovie", "Movie Not Found!");
        }
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/editmovie", method=RequestMethod.POST)
    public ModelAndView editMovie(@ModelAttribute("foundMovie") Movie movie){
        ModelAndView mv = new ModelAndView("adminEditMovie");
        //edit movie info
        mv.addObject("foundMovie", movie);
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/addmovie", method=RequestMethod.POST)
    public ModelAndView addMovie(@ModelAttribute("movie") Movie movie){
        ModelAndView mv = new ModelAndView("adminPage");
        if(!movieManager.addMovie(movie)){
            mv.addObject("mconfirmation", false);
        }else{
            mv.addObject("mconfirmation", true);
        }
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/delmovie", method=RequestMethod.GET)
    public ModelAndView delMovie(HttpSession session){
        ModelAndView mv = new ModelAndView("adminEditMovie");
        String name = (String) session.getAttribute("foundMovieName");
        if(!movieManager.adminDelMovie(name)){
            mv.addObject("delmconfirm", false);
            mv.addObject("foundMovie", movieManager.findMovie(name));
        }else{
            mv.addObject("delmconfirm", true);
        }
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        
        return mv;
    }
    
    @RequestMapping(value="/finduser", method=RequestMethod.POST)
    public ModelAndView findUser(@RequestParam(value = "email") String email, HttpSession session){
        ModelAndView mv = new ModelAndView("adminEditUser");
        User user = userManager.findUser(email);
        if(user!=null){
            session.setAttribute("foundUserEmail", email);
            mv.addObject("foundUser", user);
        }else{
            mv.addObject("nouser", "User Not Found!");
        }
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/adminedituser", method=RequestMethod.POST)
    public ModelAndView editUser(@ModelAttribute("foundUser") User user, HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        ModelAndView mv = new ModelAndView("adminEditUser");
        String email = (String) session.getAttribute("foundUserEmail");
        boolean euconfirmation = userManager.adminEditUser(user, email);
        mv.addObject("euconfirmation", euconfirmation);
        if(euconfirmation==true){session.setAttribute("foundUserEmail" , user.getEmail());}
        mv.addObject("foundUser", user);
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        return mv;
    }
    
    @RequestMapping(value="/deluser", method=RequestMethod.GET)
    public ModelAndView delUser(HttpSession session){
        ModelAndView mv = new ModelAndView("adminEditUser");
        String email = (String) session.getAttribute("foundUserEmail");
        if(!userManager.adminDelUser(email)){
            mv.addObject("delconfirm", false);
            mv.addObject("foundUser", userManager.findUser(email));
        }else{
            mv.addObject("delconfirm", true);
        }
        mv.addObject("user", new User());
        mv.addObject("movie", new Movie());
        
        return mv;
    }
    
    @RequestMapping(value="/adduser", method=RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") User user) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        ModelAndView mv = new ModelAndView("adminPage");
        user.setRole("User");
        if(!userManager.registerUser(user)){
            mv.addObject("uconfirmation", false);
        }else{
            mv.addObject("uconfirmation", true);
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

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
    }
    
}
