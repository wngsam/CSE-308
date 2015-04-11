/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
@RequestMapping("/search")
public class SearchController {
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView search(@RequestParam(value = "searchParameter") String searchParameter){
        
        ModelAndView mv = new ModelAndView("index");
        System.out.println(searchParameter);
        return mv;
        
    }
    
}
