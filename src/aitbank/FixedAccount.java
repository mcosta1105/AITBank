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
public class FixedAccount extends Account implements Interest {

    //Attributes
    private boolean applyInterest = true;
    private float interest;
    
    
    
    //Constructor
    public FixedAccount(String accName, int accNumber) {
        super(accName, accNumber);
    }
    
    //Methods
    @Override
    public float withdraw(float amount) {
        if(amount > this.getAccBalance()){
            JOptionPane.showMessageDialog(null, "Sorry, you haven't got enough balance for this transaction.");
            return 1;
        }else if(checkNotes(amount)){
            this.setAccBalance(this.getAccBalance()- amount);
            JOptionPane.showMessageDialog(null, "Take $" + df.format(amount) +" cash.");            
            applyInterest = false;          
            return 0;
        }else{
            return 1;
        }
    }

    @Override
    public void calculateInterest() {
        interest = 0.15f;
        if(applyInterest){
            this.setAccBalance(this.getAccBalance() + (this.getAccBalance() * interest));
            System.out.println("Interest applied!");
            System.out.println("Your new balance is: $" + df.format(this.getAccBalance()));
        }else{
            System.out.println("Sorry, can't apply interest yet.");
        }
    }   
    
    
    //Method to reset interest
    public void interestWait(){
        System.out.println("... 30 days later.");
        applyInterest = true;
    }    
}
