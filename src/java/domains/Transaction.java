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
public class Transaction {
    
    private int Id;
    private int quantity;
    private double cost;
    private GregorianCalendar date;
    private PaymentMethod paymentMethod;
    //private String theater;
    //private String movie;
    private Schedule showtime;
    
    public Transaction(){
        
    }
    
    public Transaction(int id, int quantity, double cost, PaymentMethod pm, Schedule st){
        this.Id=id;
        this.quantity=quantity;
        this.cost=cost;
        this.paymentMethod=pm;
        this.showtime=st;
        date = new GregorianCalendar();
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Schedule getSchedule() {
        return showtime;
    }

    public void setSchedule(Schedule schedule) {
        showtime = schedule;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }
    
}
