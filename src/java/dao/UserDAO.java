/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domains.Movie;
import domains.PaymentMethod;
import domains.Review;
import domains.Theater;
import domains.Transaction;
import domains.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Sam W.
 */
public class UserDAO {
    
    private JdbcTemplate jdbcTemplate;
    static int count = 0;
    
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public Boolean addUser(User user){
        Boolean confirmation = false;
        String birthdate = "19000101";
        int zipcode = 00000;
        
        if(user.getZipCode()!=-1){
            zipcode = user.getZipCode();
        }
        if(user.getBirthDate()!=null){
            
        }
        
        this.jdbcTemplate.update(
        "INSERT INTO users values (?,?,?,?,?,?,?,?)",
        ++count,user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),birthdate,user.getRole(),zipcode);
        confirmation = true;
        return confirmation;
    }
    
    public List<User> update(){
        List<User> users = this.jdbcTemplate.query(
                "SELECT * FROM users;",
                new RowMapper<User>(){
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        count++;
                        int userId = rs.getInt("UserId");
                        user.setId(userId);
                        user.setFirstName(rs.getString("FirstName"));
                        user.setLastName(rs.getString("LastName"));
                        user.setEmail(rs.getString("Email"));
                        user.setPassword(rs.getString("Password"));
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("BirthDate"));
                        user.setBirthDate(cal);
                        user.setRole(rs.getString("Role"));
                        user.setZipCode(rs.getInt("Zipcode"));
                        user.setFavoriteMovies(getFavMovies(userId));
                        user.setFavoriteTheaters(getFavTheaters(userId));
                        user.setReviews(getUserReviews(userId));
                        List<PaymentMethod> paymentMethods = getPaymentMethodsByUserId(userId);
                        user.setPaymentMethods(paymentMethods);
                        user.setTransactions(getUserTransactions(paymentMethods));
                        return user;
                    }
                }
        );
        
        return users;
    }
    
    public List<String> getFavMovies(int userId){
        String query = "SELECT * FROM favoritemovies"
              + " WHERE UserId="+userId+";";
        List<String> favMovies = this.jdbcTemplate.query(
                query,
                new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("MovieId");
                    }
                }
        );
        return favMovies;
    }
    
    public List<String> getFavTheaters(int userId){
        String query = "SELECT * FROM favoritetheaters"
              + " WHERE UserId="+userId+";";
        List<String> favTheaters = this.jdbcTemplate.query(
                query,
                new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("TheaterId");
                    }
                }
        );
        return favTheaters;
    }
    
    public List<Review> getUserReviews(int userId){
        String query = "SELECT * FROM comments"
              + " WHERE UserId="+userId+";";
        List<Review> reviews = this.jdbcTemplate.query(
                query,
                new RowMapper<Review>(){
                    @Override
                    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Review review = new Review();
                        review.setTitle(rs.getString("Title"));
                        review.setUserId(userId);
                        review.setContent(rs.getString("Content"));
                        review.setMovieId(rs.getInt("MovieId"));
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("Date"));
                        review.setDate(cal);
                        review.setUpvotes(rs.getInt("Upvotes"));
                        return review;
                    }
                }
        );
        return reviews;
    }
    
    public List<Transaction> getUserTransactions(List<PaymentMethod> pm){
        List<Transaction> transactions = new ArrayList();
        for(PaymentMethod pm1 : pm){
            transactions.add(getTransaction(pm1.getPaymentMethodId(), pm1));
        }
        return transactions;
    }
    
    //MIGHT BE MISSING TIME
    public Transaction getTransaction(int pmId, PaymentMethod pm){
        String query = "SELECT * FROM transactions"
              + " WHERE PaymentMethodId="+pmId+";";
        Transaction transaction = this.jdbcTemplate.queryForObject(
                query, new RowMapper<Transaction>(){
                    @Override
                    public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Transaction transaction = new Transaction();
                        transaction.setId(rs.getInt("TransactionId"));
                        transaction.setQuantity(rs.getInt("Quantity"));
                        transaction.setCost(rs.getBigDecimal("Cost").doubleValue());
                        GregorianCalendar cal = new GregorianCalendar();
                        cal.setTime(rs.getDate("Date"));
                        transaction.setDate(cal);
                        transaction.setPaymentMethod(pm);
                        int showTimeId = rs.getInt("ShowTimeId");
                        transaction.setTheater(getTheaterName(showTimeId));
                        transaction.setMovie(getMovieTitle(showTimeId));
                        return transaction;
                    }
                }
        );
        return transaction;
    }
    
    public List<PaymentMethod> getPaymentMethodsByUserId(int userId){
        String query = "SELECT * FROM paymentmethods"
              + " WHERE UserId="+userId+";";
        List<PaymentMethod> paymentMethods = this.jdbcTemplate.query(
                query,
                new RowMapper<PaymentMethod>(){
                    @Override
                    public PaymentMethod mapRow(ResultSet rs, int rowNum) throws SQLException {
                        PaymentMethod paymentMethod = new PaymentMethod();
                        paymentMethod.setPaymentMethodId(rs.getInt("PaymentMethodId"));
                        paymentMethod.setUserId(rs.getInt("UserId"));
                        paymentMethod.setFirstName(rs.getString("FirstName"));
                        paymentMethod.setLastName(rs.getString("LastName"));
                        paymentMethod.setCreditCardNum(rs.getInt("CreditCardNum"));
                        paymentMethod.setCvv(rs.getInt("Ccv"));
                        paymentMethod.setAddress(rs.getString("Address"));
                        paymentMethod.setZipCode(rs.getInt("Zipcode"));
                        if(rs.getByte("IsPreferred") == 1){
                            paymentMethod.setIsPreferred(true);
                        }else{
                            paymentMethod.setIsPreferred(false);
                        }
                        return paymentMethod;
                    }
                }
        );
        return paymentMethods;
    }
    
    public String getTheaterName(int showTimeId){
        String query =  "SELECT Name"
                       +" FROM theaters"
                       +" WHERE theaterId = ("
                       +" SELECT theaterId"
                       +" FROM schedules"
                       +" WHERE scheduleId = (SELECT ScheduleId"
                       +"                     FROM showtimes"
                       +"                     WHERE showTimeId = "+showTimeId+"));";
        String name = this.jdbcTemplate.queryForObject(
                query, new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("Name");
                    }
                }
        );
        return name;
    }
    
    public String getMovieTitle(int showTimeId){
        String query = "SELECT Title"
                       +" FROM movies"
                       +" WHERE movieId = ("
                       +" SELECT movieId"
                       +" FROM schedules"
                       +" WHERE scheduleId = (SELECT ScheduleId"
                       +"                     FROM showtimes"
                       +"                     WHERE showTimeId = "+showTimeId+"));";
        String title = this.jdbcTemplate.queryForObject(
                query, new RowMapper<String>(){
                    @Override
                    public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getString("Title");
                    }
                }
        );
        return title;
    }
    
}
