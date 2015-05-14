/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Email;
import managers.EmailManager;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JaeWoong
 */
@Controller
public class EmailController {
    @Autowired
    private EmailManager emailManager;
    
    @RequestMapping(value="/subscribe", method = RequestMethod.POST)
    public ModelAndView sendEmailtoUser(@RequestParam(value = "email") String email) throws Exception{
    
        Email newEmail = new Email();
        System.out.print("37" + email);
        String reciver = email; //받을사람의 이메일입니다.
        String subject = "Samdango News";
        String content = "Welcome to Samdango!\n" + "We will send a recent news about new movies every day!";
         
        newEmail.setReciver(reciver);
        newEmail.setSubject(subject);
        newEmail.setContent(content);
        emailManager.SendEmail(newEmail);
         
        return new ModelAndView("index");
        }
        
   }
        
        


