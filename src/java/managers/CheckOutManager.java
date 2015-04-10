/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import domains.Transaction;
import java.util.ArrayList;

/**
 *
 * @author Sam W.
 */
public class CheckOutManager {
    
    private ArrayList<Transaction> transactions;
    
    public CheckOutManager(){
        transactions = new ArrayList();
    }
    
    public boolean addTransaction(Transaction transaction){
        return transactions.add(transaction);
    }
    
}
