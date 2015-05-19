/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;
import dao.UserDAO;
import domains.PaymentMethod;
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
    
    public boolean adminEditUser(User modifiedUser, String email) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        boolean confirmation = false;
        User user = users.get(email);
        if(user!=null){
           user.setFirstName(modifiedUser.getFirstName());
           user.setLastName(modifiedUser.getLastName());
           user.setEmail(modifiedUser.getEmail());
           //birthdate
           if(!modifiedUser.getPassword().equals("")){
               user.setPassword(hash(modifiedUser.getPassword()));
           }
           user.setRole(modifiedUser.getRole());
           user.setZipCode(modifiedUser.getZipCode());
           confirmation = userDAO.adminEditUser(user);
           if(confirmation==true){
               users.remove(email);
               users.put(user.getEmail(),user);
           }
        }
        return confirmation;
    }
    
    public boolean adminDelUser(String email){
        boolean confirmation = false;
        if(users.get(email)!=null){
            if(userDAO.adminDelUser(users.get(email).getId())){
                users.remove(email);
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
    
    public boolean editPassword(User user, String newPwd) throws UnsupportedEncodingException, NoSuchAlgorithmException{
        boolean confirmation = false;
        user.setPassword(hash(newPwd));
        userDAO.editPassword(user, hash(newPwd));
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
    
     public int generateRandomPassword()  throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Random r = new Random();
        int randomID = r.nextInt(999999999-100000000) + 100000000;
        
       // if(randomID==)
        return randomID;
    }

    public void addPaymentMethod(PaymentMethod paymentMethod, User user) {
        
        userDAO.addPaymentMethod(paymentMethod, user);
    
    }

    public void deletePaymentMethod(int creditCardId) {
        userDAO.deletePaymentMethod(creditCardId);
    }

    public void setPreferredPayment(int creditCardId) {
        userDAO.setPreferredPaymentMethod(creditCardId);
    }
    
}
