/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import managers.UserManager;
import domains.User;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.View;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DreamRealizer
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
    private UserManager userManager;
    
  
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "email") String email,
                    @RequestParam(value = "password") String password,
                    HttpSession session) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        
        User user = userManager.authenticate(email, password); 
        ModelAndView mv= new ModelAndView("index");
        
        if(user!=null){
            session.setAttribute("currentPerson", user);
        }else{
            mv.addObject("cannotLogin", "Wrong Password or Email");
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
