/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Movie;
import domains.PaymentMethod;
import domains.Review;
import domains.Schedule;
import domains.Theater;
import domains.Transaction;
import domains.User;
import java.util.List;
import managers.MovieManager;
import org.springframework.stereotype.Controller;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpSession;
import managers.TheaterManager;
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
     private TheaterManager theaterManager;

  
     //  @RequestMapping(value="/movieInfoPage", method=RequestMethod.GET)
       // public ModelAndView viewMovieInfo(){
       
    @RequestMapping(value="/buy={id}", method = RequestMethod.GET)
    public ModelAndView buy(@PathVariable("id") int id){
        ModelAndView mv = new ModelAndView("checkout");
        Schedule sch = movieManager.getScheduleById(id);
        //System.out.println(sch.getAMPM());
        sch.setTheaterName(theaterManager.getTheaterNameById(sch.getTheaterId()));
        mv.addObject("buysch", sch);
        mv.addObject("pstep", 1); //1 = ticket page, 2 = payment page 3 = finished pg
        return mv;
    }
    
    @RequestMapping(value="/pay={id}", method = RequestMethod.POST)
    public ModelAndView pay(@PathVariable("id") int id, @RequestParam(value = "adult") int adult, @RequestParam(value = "child") int ch, @RequestParam(value = "senior") int sr){
        ModelAndView mv = new ModelAndView("checkout");
        mv.addObject("buysch", movieManager.getScheduleById(id));
        mv.addObject("adult", adult); //need better way EDIT!
        mv.addObject("child", ch);
        mv.addObject("senior", sr);
        int total = (adult*12+ch*9+sr*7);
        mv.addObject("tickets", (adult+ch+sr));
        mv.addObject("totalCost",total);
        mv.addObject("paymentmethod", new PaymentMethod());
        mv.addObject("pstep", 2); //1 = ticket page, 2 = payment page 3 = finished pg
        return mv;
    }
    
    @RequestMapping(value="/postcheckout={stuff}", method = RequestMethod.POST)
    public ModelAndView checkout(@PathVariable("stuff") String stuff, @RequestParam(value = "email") String email, @RequestParam(value = "firstname") String firstname,
    @RequestParam(value = "lastname") String lastname, @RequestParam(value = "ccn") String ccn, @RequestParam(value = "ccv") String ccv,
            @RequestParam(value = "address") String address, HttpSession session){
        
        ModelAndView mv = new ModelAndView("checkout");
        PaymentMethod guest = new PaymentMethod((int )(Math.random() * 100 + 100),0,firstname,lastname,ccn,ccv,address,"",false);
        String[] s = stuff.split(",");
        Transaction guestTransc = new Transaction((int )(Math.random() * 10000 + 1111989),
        Integer.parseInt(s[1]), Integer.parseInt(s[2]),guest,movieManager.getScheduleById(Integer.parseInt(s[0])));
        movieManager.addTransc(guestTransc,0);
        mv.addObject("bill",guestTransc);
        
        mv.addObject("pstep", 3); //1 = ticket page, 2 = payment page 3 = finished pg
        return mv;
    }
    
    @RequestMapping(value="/usercheckout={stuff}", method = RequestMethod.POST)
    public ModelAndView usercheckout(@PathVariable("stuff") String stuff, HttpSession session, @ModelAttribute("paymentmethod") PaymentMethod pm){
        
        ModelAndView mv = new ModelAndView("checkout");
        String[] s = stuff.split(",");
        User user = (User) session.getAttribute("currentPerson");
        pm.setId((int )(Math.random() * 100 + 100));
        pm.setUserId(user.getId());
        user.getPaymentMethods().add(pm);
        Transaction transc = new Transaction((int )(Math.random() * 10000 + 1111989),
        Integer.parseInt(s[1]), Integer.parseInt(s[2]),pm,movieManager.getScheduleById(Integer.parseInt(s[0])));
        user.getTransactions().add(transc);
        movieManager.addTransc(transc,0);
        mv.addObject("bill",transc);
        
        mv.addObject("pstep", 3); //1 = ticket page, 2 = payment page 3 = finished pg
        return mv;
    }
    
    @RequestMapping(value="/usercheckout2={stuff}", method = RequestMethod.GET)
    public ModelAndView usercheckout2(@PathVariable("stuff") String stuff, HttpSession session){
        
        ModelAndView mv = new ModelAndView("checkout");
        String[] s = stuff.split(",");
        User user = (User) session.getAttribute("currentPerson");
        Transaction transc = new Transaction((int )(Math.random() * 10000 + 1111989),
        Integer.parseInt(s[1]), Integer.parseInt(s[2]),user.findPM(Integer.parseInt(s[3])),movieManager.getScheduleById(Integer.parseInt(s[0])));
        user.getTransactions().add(transc);
        movieManager.addTransc(transc,1);
        mv.addObject("bill",transc);
        
        mv.addObject("pstep", 3); //1 = ticket page, 2 = payment page 3 = finished pg
        return mv;
    }
    
    @RequestMapping(value="/gc={stuff}", method = RequestMethod.POST)
    public ModelAndView giftcardcheckout(@PathVariable("stuff") String stuff, HttpSession session){
        
        ModelAndView mv = new ModelAndView("checkout");
        String[] s = stuff.split(",");
        //FIND GC VALID
        Transaction transc = new Transaction((int )(Math.random() * 10000 + 1111989),
        Integer.parseInt(s[1]), Integer.parseInt(s[2]),new PaymentMethod(),movieManager.getScheduleById(Integer.parseInt(s[0])));
        //IF USER, ADD TO USER
        //ADD TO DB
        mv.addObject("bill",transc);
        //GIVE BACK GC STATUS
        mv.addObject("pstep", 3); //MAYBE
        return mv;
    }
    
    @RequestMapping(value="{title}", method = RequestMethod.GET)
    public ModelAndView viewMovieInfo(@PathVariable("title") String movieTitle, HttpSession session) {
        
        ModelAndView mv = new ModelAndView("movieInfoPage");
        Movie currentMovie = movieManager.getCurrentMovie(movieTitle);
        session.setAttribute("movieTitle", movieTitle);
        mv.addObject("currentMovie", currentMovie);
//        if(session.getAttribute("ZIPC")!=null){
//            session.setAttribute("nearbytheaters",theaterManager.findNearbyTheaters((int)session.getAttribute("ZIPC")));
//        }
        return mv;
    }
    
    @RequestMapping(value="/location", method = RequestMethod.POST)
    public ModelAndView zipcode(@RequestParam(value = "zipcode") int zip, HttpSession session){
        ModelAndView mv = new ModelAndView("movieInfoPage");
        mv.addObject("currentMovie", movieManager.getCurrentMovie((String)session.getAttribute("movieTitle")));
        session.setAttribute("ZIPC", zip);
//        List<Theater> theaters = theaterManager.findNearbyTheaters((int)session.getAttribute("ZIPC"));
//        if(theaters!=null && !theaters.isEmpty()){
//            session.setAttribute("nearbytheaters",theaters);
//        }
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
        movieManager.updateSchedule();
    }

    public TheaterManager getTheaterManager() {
        return theaterManager;
    }

    public void setTheaterManager(TheaterManager theaterManager) {
        this.theaterManager = theaterManager;
        theaterManager.updateTheaters();
    }
    
    
    
}
