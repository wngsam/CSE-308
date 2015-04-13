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
public class Theater {
    private int id;
    private String name;
    private String address;
    private int zipCode;
    private String phone;
    private HashMap<String,Schedule> schedules;
    private String amenities;
    
    public Theater(){}
    
    public Theater(String name, String address, int zipCode, String phone, String amenities){
        this.name=name;
        this.address=address;
        this.zipCode=zipCode;
        this.phone=phone;
        this.amenities=amenities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(HashMap<String, Schedule> schedules) {
        this.schedules = schedules;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }
    
    
    
}
