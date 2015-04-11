/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;
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
    
    private HashMap<String,User> users;
    
    UserManager() throws UnsupportedEncodingException, NoSuchAlgorithmException{
        users = new HashMap();
        createTestUsers();
    }
    
    public void createTestUsers() throws UnsupportedEncodingException, NoSuchAlgorithmException{
        User userOne = new User("Sam", "Wang", "sam.wang@stonybrook.edu", hash("abc123"), "User");
        User userTwo = new User("Youngseo", "Son", "youngseo.son@stonybrook.edu", hash("123abc"), "User");
        User userThree = new User("Jaewoong", "Shin", "@jaewoong.shin@stonybrook.edu", hash("cba321"), "User");
        User userFour = new User("David", "Lui", "david.lui@stonybrook.edu", hash("321cba"), "User");
        users.put(userOne.getEmail(),userOne);
        users.put(userTwo.getEmail(),userTwo);
        users.put(userThree.getEmail(),userThree);
        users.put(userFour.getEmail(),userFour);
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
            users.put(user.getEmail(),user);
            confirmation = true;
        }
        
        return confirmation;
    }
    
    public String hash(String password) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String hashed = new String(Hex.encodeHexString(md.digest(password.getBytes("UTF-8"))));
        
        return hashed;
    }
    
}
