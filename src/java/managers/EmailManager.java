/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Email;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
 
//import com.bean.Email;
/**
 *
 * @author JaeWoong
 */
@Component
public class EmailManager {
     @Autowired
    protected JavaMailSender  mailSender;
 
    public void SendEmail(Email email) throws Exception  {
         
        MimeMessage msg = mailSender.createMimeMessage();
        msg.setSubject(email.getSubject());
        msg.setText(email.getContent());
        msg.setRecipient(RecipientType.TO , new InternetAddress(email.getReciver()));
         
        mailSender.send(msg); 
    }
}
