/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;
import dao.UserDAO;
import domains.User;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.binary.Hex;
import java.util.*;
/**
 *
 * @author DreamRealizer
 */
public class UserManager {
    
    private UserDAO userDAO;
    private HashMap<String,User> users;
    
    UserManager() throws UnsupportedEncodingException, NoSuchAlgorithmException{
        //users = new HashMap();
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
        List<User> toBeAdded = userDAO.update();
        users = new HashMap();
        for(User u : toBeAdded){
            users.put(u.getEmail(),u);
        }
    }
    
    public User findUser(String email){
        return users.get(email);
    }
    
    public User authenticate(String email, String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        User user = users.get(email);
        
        if(user!=null){
            if(!hash(password).equals(user.getPassword())){
                user = null;
            }
        }
        
        return user;
    }
    
    public boolean registerUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        boolean confirmation = false;
        if(users.get(user.getEmail())==null){
            user.setPassword(hash(user.getPassword()));
            //System.out.println(user.getPassword());
            if(userDAO.addUser(user)==true){
                users.put(user.getEmail(),user);
                confirmation = true;
            }
        }
        
        return confirmation;
    }
    
    public boolean editUser(User user) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        boolean confirmation = false;
        userDAO.editUser(user);
        confirmation = true;        
        return confirmation;
    }
    
    public String hash(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashed = new String(Hex.encodeHexString(md.digest(password.getBytes("UTF-8"))));
        
        return hashed;
    }

    public HashMap<String, User> getUsers() {
        return users;
    }

    public void setUsers(HashMap<String, User> users) {
        this.users = users;
    }
    
}
