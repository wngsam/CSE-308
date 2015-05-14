/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import dao.GiftcardDAO;
import domains.Giftcard;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author JaeWoong
 */
public class GiftCardManager {
    private GiftcardDAO giftcardDAO;
    private HashMap<Integer, Giftcard> giftcards;

    public GiftcardDAO getGiftcardDAO() {
        return giftcardDAO;
    }

    public HashMap<Integer, Giftcard> getGiftcards() {
        return giftcards;
    }

    public void setGiftcardDAO(GiftcardDAO giftcardDAO) {
        this.giftcardDAO = giftcardDAO;
    }

    public void setGiftcards(HashMap<Integer, Giftcard> giftcards) {
        this.giftcards = giftcards;
    }
    
    public GiftCardManager() throws UnsupportedEncodingException, NoSuchAlgorithmException {
         giftcards = new HashMap();
      
    } 
      
    public int generateGiftCardId()  throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Random r = new Random();
        int randomID = r.nextInt(999999999-100000000) + 100000000;
        
       // if(randomID==)
        return randomID;
    }
    
    public void registerGiffCardId(int giftcardId, int amount)  throws UnsupportedEncodingException, NoSuchAlgorithmException{
        Giftcard giftcard = new Giftcard();
        giftcard.setAmount(amount);
        giftcard.setGiftcardId(giftcardId);
        
        giftcards.put(giftcardId,giftcard);
        boolean flag =giftcardDAO.addGiftcard(giftcard);
        System.out.println("giftcard DAO working");
    }
}
