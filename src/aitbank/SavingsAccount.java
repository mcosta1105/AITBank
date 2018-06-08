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
public class SavingsAccount extends Account implements Interest {
    
    //Attributes
    private float dailyWithdrawalLimit;
    private float interest;
   
    
    //Constructor
    public SavingsAccount(String accName, int accNumber){
        super(accName, accNumber);
    }
    
    //Methods    
    @Override
    public float withdraw(float amount) {
        if(amount > this.getAccBalance()){
            JOptionPane.showMessageDialog(null, "Sorry, you haven't got enough balance for this transaction.");
            return 1;
        }else if(amount > this.getDailyWithdrawLimit()){
            JOptionPane.showMessageDialog(null, "Sorry, that exceeds your daily withdrawal limit.");
            return 1;
        }else if(checkNotes(amount)){
            this.setAccBalance(this.getAccBalance()- amount);
            JOptionPane.showMessageDialog(null, "Take $" + df.format(amount) +" cash.");
            return 0;
        }
        else{
            return 1;
        }
    }
    
    @Override
    public void calculateInterest() {
        interest = 0.07f;
        this.setAccBalance(this.getAccBalance() + (this.getAccBalance() * interest));
        System.out.println("Your new balance is: $" + df.format(this.getAccBalance()));
    }
    
    //Getters and setters
    public float getDailyWithdrawLimit() {
        return dailyWithdrawalLimit;
    }

    
    public void setDailyWithdrawalLimit(float dailyWithdrawLimit){
        
        if(dailyWithdrawLimit >0){
                this.dailyWithdrawalLimit = dailyWithdrawLimit;
                System.out.println("Daily withdrawal limit successfully applied!");
        }else{
        System.out.println("Daily withdrawal limit successfully applied!");
        }
        /*
        if(dailyWithdrawLimit < 0){
                throw new NegativeDepositException();
        }
        this.dailyWithdrawalLimit = dailyWithdrawLimit;
        System.out.println("Daily withdrawal limit successfully applied!");
            
            //System.out.println("Sorry, your daily withdrawal limit must be greater than 0.");
        */
    }
   
}
