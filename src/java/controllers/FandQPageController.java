/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JaeWoong
 */
@Controller
public class FandQPageController {
    
    @RequestMapping(value="/fnqPage", method=RequestMethod.GET)
    public ModelAndView displayFnQPage(){
        ModelAndView mv = new ModelAndView("fnqPage");
        
        return mv;
    }
}
