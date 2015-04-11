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
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private GregorianCalendar birthDate;
    private String role;
    private int zipCode;
    private Collection<Movie> favoriteMovies;
    private Collection<Theater> favoriteTheaters;
    private List<Review> reviews;
    private Collection<PaymentMethod> paymentMethods;
    private PaymentMethod preferredPaymentMethod;
    private List<Transaction> transactions;
    
    public User(){
        
    }
    
    public User(String firstName, String lastName, String email, String password, String role){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.password=password;
        this.role=role;
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
    
}
