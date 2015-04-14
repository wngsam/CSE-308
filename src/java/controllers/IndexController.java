/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import managers.MovieManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Sam W.
 */

@Controller
public class IndexController {
    
    private MovieManager movieManager;
    
    @RequestMapping(value="/index")
    public ModelAndView displayIndex(){
        ModelAndView mv = new ModelAndView("index");
        
        return mv;
    }
    
}
