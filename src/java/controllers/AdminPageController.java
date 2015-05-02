/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W.
 */
@Controller
@RequestMapping("/adminpage")
public class AdminPageController {
    
    @RequestMapping(method=RequestMethod.GET)
    public ModelAndView viewAdminPage(HttpSession session){
        ModelAndView mv = new ModelAndView("adminPage");
        return mv;
    }
    
}
