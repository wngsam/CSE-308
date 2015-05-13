/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

/**
 *
 * @author DreamRealizer
 */
public class PaymentMethod {
    private int id;
    private int userId;
    private String firstName;
    private String lastName;
    private int creditCardNum;
    private int ccv;
    private String address;
    private int zipCode;
    private boolean isPreferred;

    public PaymentMethod() {
        
    }
    public int getPaymentMethodId() {
        return id;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.id = paymentMethodId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public int getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(int creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public int getCcv() {
        return ccv;
    }

    public void setCcv(int cvv) {
        this.ccv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(boolean isPreferred) {
        this.isPreferred = isPreferred;
    }
    
}
