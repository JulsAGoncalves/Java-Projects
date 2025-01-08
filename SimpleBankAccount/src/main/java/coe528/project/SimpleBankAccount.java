/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 *
 * @author Julian Goncalves
 */
public abstract class SimpleBankAccount {
    
    protected int balance;
    
    //<Effects>: sets the initial balance to 100
    //<Modifies>: nothing
    //<Requires>: nothing
    public SimpleBankAccount(){
        balance = 100;
    }
    
    //<Effects>: returns the current balance
    //<Modifies>: nothing
    //<Requires>: nothing
    protected int getBalance(){
        return balance;
    }
    
    //<Effects>: sets balance to the newBalance if it's >= 0
    //<Modifies>: balance to newBalance
    //<Requires>: newBalance
    protected void setBalance(int newBalance){
        if(newBalance >= 0)
            this.balance = newBalance;
    }
    
    
    //<Effects>: adds the amount to balance if the amount is >= 0
    //<Modifies>: balance with amount
    //<Requires>: amount
    protected void addAmount(int amount){
        balance += amount;
    }
    
    //<Effects>: removes the amount from the balance if the amount is >= 0 and <= the current balance
    //<Modifies>: balance with amount
    //<Requires>: amount
    protected void removeAmount(int amount){
            balance -= amount;
    }
    
    //<Effects>: makes an online purchase if the purchase is >= 50 and the current balance is >= the purchase + the service charge
    //<Modifies>: balance with amount (amount = purchase price with service charge)
    //<Requires>: amount
    public void onlinePurchase(int amount){} 
    
    
    //<Effects>: returns the current account level
    //<Modifies>: nothing
    //<Requires>: nothing
    public  String getAccountLevel(){return "String in abstract";}
    
    
    //<Effects>: returns the abstration function
    //<Modifies>: nothing
    //<Requires>: nothing
    @Override
    public String toString(){
        return "Balance is $" + balance;
    }
    
    //<Effects>: returns true so long as the rep invariant is true
    //<Modifies>: nothing
    //<Requires>: nothing
    public boolean RepOK(){
        if(this.balance > 0)
            return true;
        return false;
    }
    
}
