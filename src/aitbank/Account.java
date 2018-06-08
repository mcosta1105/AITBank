/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aitbank;

import java.text.DecimalFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author 5661
 */
public abstract class Account{
    //Attributes
    private String accName;
    private int accNumber;
    private float accBalance;
    
    DecimalFormat df = new DecimalFormat("#.##"); // To display 2 decimal places only
    
    //Constructor
    public Account(String accName, int accNumber) {
        this.accName = accName;
        this.accNumber = accNumber;
        //this.accBalance = accBalance;
    }
    
    
    //Methods
    public abstract float withdraw(float amount);
       
    //Check notes method ( checks if value is requested can be reached with 20, 50 and 100 notes)
    public boolean checkNotes(float amount){
        if(amount == 20){
            return true;
        }else if(amount >= 40 && amount % 10 == 0){
            return true;
        }
        JOptionPane.showMessageDialog(null,"Sorry, only 20, 50 and 100 notes available.");
        return false;
    }
    
    public void balanceInquiry() {
        System.out.println("Your current balance is: $"+ df.format(this.getAccBalance()));
    }
    
    public float deposit(float amount) {
            this.setAccBalance(this.getAccBalance() + amount);
            return 0;
    }
     
    
    //Getters and Setters methods
    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public float getAccBalance() {
        return accBalance;
    }

    public void setAccBalance(float accBalance) {
        this.accBalance = accBalance;
    }    
   
}
