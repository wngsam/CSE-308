/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domains;

/**
 *
 * @author JaeWoong
 */
public class Giftcard {
    private int giftcardId;
    private int amount;
    
     public Giftcard(){
        
    }

    public int getGiftcardId() {
        return giftcardId;
    }

    public void setGiftcardId(int giftcardId) {
        this.giftcardId = giftcardId;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
