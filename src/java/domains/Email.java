/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

/**
 *
 * @author JaeWoong
 */
public class Email {

    private String subject;
    private String content;
    private String regdate;
    private String reciver;
     
    public String getReciver() {
        return reciver;
    }
    public void setReciver(String reciver) {
        this.reciver = reciver;
    }

    public String getSubject() {
        return subject;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getRegdate() {
        return regdate;
    }
    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
     
     
}
