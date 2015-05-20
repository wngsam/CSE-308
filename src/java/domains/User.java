/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author DreamRealizer
 */
public class User implements Serializable{
    
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private GregorianCalendar birthDate;
    private String role;
    private int zipCode =-1;
    private List<String> favoriteMovies;
    private List<String> favoriteTheaters;
    private List<Review> reviews;
    private List<Transaction> transactions;
    private List<PaymentMethod> paymentMethods;
    private PaymentMethod preferredPaymentMethod;
    private String bd;   
    
    public User(){
        
    }
    
    public Transaction findT(int id){
        if(transactions!=null && !transactions.isEmpty()){
        for(Transaction t : transactions){
            System.out.println("T SIZE: "+transactions.size());
            //System.out.println("T ID: "+t.getId());
            if(t.getId()==id){
                return t;
            }
        }
        }
        return null;
    }
    
    public PaymentMethod findPM(int id){
        for(PaymentMethod pm : paymentMethods){
            if(pm.getId()==id){
                return pm;
            }
        }
        return null;
    }
    
    public List<String> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(List<String> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public List<String> getFavoriteTheaters() {
        return favoriteTheaters;
    }

    public void setFavoriteTheaters(List<String> favoriteTheaters) {
        this.favoriteTheaters = favoriteTheaters;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<PaymentMethod> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public List<Transaction> getTransactions() {
        if(transactions==null){
            transactions= new ArrayList();
        }
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
        
        int day=birthDate.get(GregorianCalendar.DAY_OF_MONTH);
        int month=birthDate.get(GregorianCalendar.MONTH);
        int year=birthDate.get(GregorianCalendar.YEAR);
        bd = new String();
        this.bd=day+"/"+month+"/"+year;
                
    }
        
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public PaymentMethod getPreferredPaymentMethod() {
        return preferredPaymentMethod;
    }

    public void setPreferredPaymentMethod(PaymentMethod preferredPaymentMethod) {
        this.preferredPaymentMethod = preferredPaymentMethod;
    }
    
    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {    
        this.bd = bd; 
        String[] st = bd.split("/");
        this.birthDate = new GregorianCalendar(Integer.parseInt(st[2]),Integer.parseInt(st[1]),Integer.parseInt(st[0]));        
    }
    
}
