/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aitbank;

import javax.swing.JOptionPane;

/**
 *
 * @author 5661
 */
public class NetSaverAccount extends Account implements Interest{

    //Attributes
    private float dailyWithdrawalLimit = 1000f;
    private float interest;
    
    
    //Constructor
    public NetSaverAccount(String accName, int accNumber) {
        super(accName, accNumber);
    }

    //Methods
    @Override
    public float withdraw(float amount) {
        if(amount > this.getAccBalance()){
            JOptionPane.showMessageDialog(null, "Sorry, you haven't got enough balance for this transaction.");
            return 1;
        }else if(amount > this.getDailyWithdrawalLimit()){
            JOptionPane.showMessageDialog(null, "Sorry, that exceeds your daily withdrawal limit.");
            return 1;
        }else if(checkNotes(amount)){
            this.setAccBalance(this.getAccBalance()- amount);
            JOptionPane.showMessageDialog(null, "Take $" + df.format(amount) +" cash.");
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public void calculateInterest() {
        interest = 0.09f;
        this.setAccBalance(this.getAccBalance() + (this.getAccBalance() * interest));
        System.out.println("Your new balance is: $" + df.format(this.getAccBalance()));
    }

    //Getters and setters
    public float getDailyWithdrawalLimit() {
        return dailyWithdrawalLimit;
    }
    
    
}
