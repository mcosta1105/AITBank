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
public class ChequeAccount extends Account{

    public ChequeAccount(String accName, int accNumber) {
        super(accName, accNumber);
    }

    @Override
    public float withdraw(float amount) {
        if(amount > this.getAccBalance()){
            JOptionPane.showMessageDialog(null, "Sorry, you haven't got enough balance for this transaction.");
            return 1;
        }else if(checkNotes(amount)){
            this.setAccBalance(this.getAccBalance()- amount);
            JOptionPane.showMessageDialog(null, "Take $" + df.format(amount) +" cash.");
            return 0;
        }else{
            return 1;
        }
    }
}
