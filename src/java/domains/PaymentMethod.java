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
    private String creditCardNum;
    private int cvv;
    private String address;
    private int zipCode;
    private boolean isPreferred;

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

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
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

    public boolean isIsPreferred() {
        return isPreferred;
    }

    public void setIsPreferred(boolean isPreferred) {
        this.isPreferred = isPreferred;
    }
    
}
