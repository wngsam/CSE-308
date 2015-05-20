/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Transaction;
import domains.User;
import javax.servlet.http.HttpSession;
import managers.MovieManager;
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
public class IndexController {
    
    @RequestMapping(value="/index")
    public ModelAndView displayIndex(){
        ModelAndView mv = new ModelAndView("index");
        
        return mv;
    }
    
    @RequestMapping(value="/refund", method = RequestMethod.GET)
    public ModelAndView refund(){
        ModelAndView mv = new ModelAndView("refund");
        mv.addObject("rstep",1);
        return mv;
    }
    
    @RequestMapping(value="/refund", method = RequestMethod.POST)
    public ModelAndView processRefund(@RequestParam("code") int code, HttpSession session){
        ModelAndView mv = new ModelAndView("refund");
//        User user = (User) session.getAttribute("currentPerson");
//        Transaction t = user.findT(code);
//        if(t!=null){
//            mv.addObject("t",t);
//            //MARK TRANSACTION
//            mv.addObject("rstep",2);
//        }else{
            mv.addObject("wrongT","INVALID CODE");
            mv.addObject("rstep",1);
        //}
        return mv;
    }
    
}
