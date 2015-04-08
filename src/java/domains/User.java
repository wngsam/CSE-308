/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

import java.util.*;

/**
 *
 * @author DreamRealizer
 */
public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    GregorianCalendar birthDate;
    String role;
    int zipCode;
    Collection<Movie> favoriteMovies;
    Collection<Theater> favoriteTheaters;
    List<Review> reviews;
    Collection<PaymentMethod> paymentMethods;
    PaymentMethod preferredPaymentMethod;
    List<Transaction> transactions;
    
    
}
