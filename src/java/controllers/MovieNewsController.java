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
public class MovieNewsController {
    @RequestMapping(value="/movieNewsPage", method=RequestMethod.GET)
    public ModelAndView displayMovieNewsPage(){
        ModelAndView mv = new ModelAndView("movieNewsPage");
        
        return mv;
    }
    
    @RequestMapping(value="/movieNews1", method=RequestMethod.GET)
    public ModelAndView displayMovieNews1(){
        ModelAndView mv = new ModelAndView("movieNews1");
        String movieNewsTrailer="http://www.fandango.com/fplayer/Player.aspx?mpxId=2666627256&genre=Action/Adventure,Comedy&adcategory=Weekend%20Ticket&playerversion=flash&noAd=false&title=WeekendTicketwithReeseWitherspoonandSofiaVergara&playListName=+Weekend+Ticket+&rt=PG-13#playerurl=http%3A//www.fandango.com/weekend-ticket/video_25";
        String movieNewsContent1="WEEKEND TICKET WITH REESE WITHERSPOON AND SOFIA VERGARA";
        String movieNewsContent2="Which movie's right for you this weekend? Hot Pursuit? Fandango Chief Correspondent Dave Karger breaks it down with a little help from Reese Witherspoon and Sofia Vergara.";
        mv.addObject("movieNewsTrailer", movieNewsTrailer);
        mv.addObject("movieNewsContent1", movieNewsContent1);
        mv.addObject("movieNewsContent2", movieNewsContent2);
        return mv;
    }
    
    @RequestMapping(value="/movieNews2", method=RequestMethod.GET)
    public ModelAndView displayMovieNews2(){
        ModelAndView mv = new ModelAndView("movieNews2");
        String movieNewsTrailer="http://video.fandango.com/NewFandangoMovies/MMM_Avengers/495/569/MMM_Avengers-2500.mp4";
        String movieNewsContent1="MOM'S MOVIE MINUTE - AVENGERS: AGE OF ULTRON";
        String movieNewsContent2="";
        mv.addObject("movieNewsTrailer", movieNewsTrailer);
        mv.addObject("movieNewsContent1", movieNewsContent1);
        mv.addObject("movieNewsContent2", movieNewsContent2);
        return mv;
    }
    
    @RequestMapping(value="/movieNews3", method=RequestMethod.GET)
    public ModelAndView displayMovieNews3(){
        ModelAndView mv = new ModelAndView("movieNews3");
        String movieNewsTrailer="http://www.fandango.com/fplayer/Player.aspx?mpxId=2666294923&genre=&adcategory=Reel%20Kids&playerversion=flash&noAd=false&title=ReelKidsGeekWeek&playListName=+Reel+Kids+&rt=#playerurl=http%3A//www.fandango.com/reel-kids/video_93";
        String movieNewsContent1="REEL KIDS: GEEK WEEK";
        String movieNewsContent2="";
        mv.addObject("movieNewsTrailer", movieNewsTrailer);
        mv.addObject("movieNewsContent1", movieNewsContent1);
        mv.addObject("movieNewsContent2", movieNewsContent2);
        return mv;
    }
    
    @RequestMapping(value="/movieNews4", method=RequestMethod.GET)
    public ModelAndView displayMovieNews4(){
        ModelAndView mv = new ModelAndView("movieNews4");
        String movieNewsTrailer="http://www.fandango.com/fplayer/player.aspx?mid=0&mpxId=2655376880&dm=3&genre=&rt=NR&title=&w=926&h=521&emb=user%27";
        String movieNewsContent1="FrontRunners: A Look Back";
        String movieNewsContent2="";
        mv.addObject("movieNewsTrailer", movieNewsTrailer);
        mv.addObject("movieNewsContent1", movieNewsContent1);
        mv.addObject("movieNewsContent2", movieNewsContent2);
        return mv;
    }
}

