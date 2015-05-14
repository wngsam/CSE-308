/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import domains.Email;
import domains.User;
import managers.EmailManager;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import managers.UserManager;
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
    private UserManager userManager;
    
    @RequestMapping(value="/subscribe", method = RequestMethod.POST)
    public ModelAndView sendEmailtoUser(@RequestParam(value = "email") String email) throws Exception{
    
        Email newEmail = new Email();
        System.out.print("37" + email);
        String reciver = email; // receiver's e-mail address.
        String subject = "Subscribe Title";
        String content = "Subscribe Content";
         
        newEmail.setReciver(reciver);
        newEmail.setSubject(subject);
        newEmail.setContent(content);
        emailManager.SendEmail(newEmail);
         
        return new ModelAndView("index");
        }
    @RequestMapping(value="/forgotPassword",method=RequestMethod.GET)
    public ModelAndView forgotPassword() throws Exception{
        return new ModelAndView("forgotPassword");
    }
    @RequestMapping(value="/resetPassword", method = RequestMethod.POST)
    public ModelAndView sendPasswordToUser(@RequestParam(value = "email") String email) throws Exception{
    
        
        if(userManager.getUsers().containsKey(email))
        {
        User user=userManager.getUsers().get(email);
        
        Email newEmail = new Email();
        String reciver = email; // receiver's e-mail address.
        String subject = "Your New Password";
        String newPassword=""+userManager.generateRandomPassword();
        userManager.editPassword(user, newPassword);
        String content = "Hello!\n"
                + "You requested a new password.\n"
                + "Your temporary password is: '"+newPassword+"'\n\n"
                + "Please, log in with this password and change your password to a secure password.\n\n"
                + "Sincerely,\n"
                + "Samdango Manager";
         
        newEmail.setReciver(reciver);
        newEmail.setSubject(subject);
        newEmail.setContent(content);
        emailManager.SendEmail(newEmail);
         
        return new ModelAndView("index");
        }
        else
        {
            ModelAndView mv = new ModelAndView("forgotPassword");
            mv.addObject("nonExist","nonExist");
            return mv;
        }        
        
        }
    
     public UserManager getUserManager() {
        return userManager;
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
        
   }
        
        


