/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Movie;
import domains.Review;
import domains.User;
import java.util.List;
import managers.MovieManager;
import org.springframework.stereotype.Controller;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JaeWoong
 */
@Controller
public class MovieInfoController {
    
     private MovieManager movieManager;

  
     //  @RequestMapping(value="/movieInfoPage", method=RequestMethod.GET)
       // public ModelAndView viewMovieInfo(){
       
     
    @RequestMapping(value="{title}", method = RequestMethod.GET)
    public ModelAndView viewMovieInfo(@PathVariable("title") String movieTitle, HttpSession session) {
        
        ModelAndView mv = new ModelAndView("movieInfoPage");
        Movie currentMovie = movieManager.getCurrentMovie(movieTitle);
        session.setAttribute("movieTitle", movieTitle);
        mv.addObject("currentMovie", currentMovie);
       
        return mv;
    }
    
    @RequestMapping(value="/star={num}", method = RequestMethod.GET)
    public ModelAndView star(@PathVariable("num") int num, HttpSession session){
        ModelAndView mv = new ModelAndView("movieInfoPage");
        String movieTitle = (String)session.getAttribute("movieTitle");
        Movie currentMovie = movieManager.getCurrentMovie(movieTitle);
        if(session.getAttribute("currentPerson")!=null){    
            currentMovie.setStars((currentMovie.getStars()+num));
            currentMovie.setRates((currentMovie.getRates()+1));
            currentMovie.calculateStarRating();
            //System.out.println(currentMovie.getStars()+" "+currentMovie.getRates()+" "+currentMovie.getStarRating());
            if(movieManager.star(currentMovie)){
                mv.addObject("starSuccess",true);
            }
        }else{
            mv.addObject("didnotLogin",true);
        }
        
        mv.addObject("currentMovie", currentMovie);
        return mv;
    }
    
    @RequestMapping(value="/delcomment={title}", method = RequestMethod.GET)
    public ModelAndView removeComment(@PathVariable("title") String titleid, HttpSession session){
        ModelAndView mv = new ModelAndView("movieInfoPage");
        String movieTitle = (String)session.getAttribute("movieTitle");
        Movie currentMovie = movieManager.getCurrentMovie(movieTitle);
        Review comment = new Review();
        String[] s = titleid.split(",");
        int userId = Integer.parseInt(s[1]);
        //System.out.println(titleid);
        for(int i=0;i<currentMovie.getReviews().size();i++){
            Review r = currentMovie.getReviews().get(i);
            if(r.getTitle().equals(s[0]) && r.getUserId()==userId){
                currentMovie.getReviews().remove(i);
                comment=r;
                i=currentMovie.getReviews().size();
            }
        }
        
        if(!movieManager.remComment(comment)){
            currentMovie.getReviews().add(comment);
        }
        
        mv.addObject("currentMovie", currentMovie);
        return mv;
    }
    
    @RequestMapping(value="/comment", method = RequestMethod.POST)
    public ModelAndView comment(@RequestParam(value = "msg")String msg, @RequestParam(value = "title")String title, HttpSession session){
        ModelAndView mv = new ModelAndView("movieInfoPage");
        String movieTitle = (String)session.getAttribute("movieTitle");
        Movie currentMovie = movieManager.getCurrentMovie(movieTitle);
        User user = (User)session.getAttribute("currentPerson");
        Review comment = new Review(title,msg,user.getId(),currentMovie.getId(),user.getFirstName());
        if(movieManager.comment(comment)){
            user.getReviews().add(comment);
            currentMovie.getReviews().add(comment);
            mv.addObject("commentSuccess",true);
        }else{
            mv.addObject("commentSuccess",false);
        }
        
        mv.addObject("currentMovie", currentMovie);
        return mv;
    }
    
    public MovieManager getMovieManager() {
           return movieManager;
       }

    public void setMovieManager(MovieManager movieManager) {
        this.movieManager = movieManager;
        movieManager.updateMovies();
    }
    
    
}
