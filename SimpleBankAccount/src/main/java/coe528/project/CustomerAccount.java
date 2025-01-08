/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 *
 * @author Julian Goncalves
 */
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.*;

public class CustomerAccount {
    
    private String username;
    private String password;
    private String role = "customer";
    private SimpleBankAccount account;
   
    public CustomerAccount(String username, String password){
        try{
            File loginInfo = new File(username + ".txt");
            if(loginInfo.createNewFile() == true){
                System.out.println("User created:" + loginInfo.getName());
                this.username = username;
                this.password = password;
                account = new SilverMember(); //After money has been deposited, the bankAccount level can change to gold/platinum
                FileWriter writeToFile = new FileWriter(username + ".txt");
                writeToFile.write(username + "\n");
                writeToFile.write(password + "\n");
                writeToFile.write(""+100);
                writeToFile.close();
            }
            else if(loginInfo.exists()){
                this.username = username;
                this.password = password;
                account = new SilverMember();
            }
            else{
                System.out.println("This User already exists!");
                return;
            }
        }catch(IOException e){
            System.out.println("IOException occured");
        }
    }
    
    public int getBalance(){
        return account.getBalance();
    }
    public void depositMoney(int amount){
        account.addAmount(amount);
        //System.out.println("$" + amount + " has been deposited");
        UpdateMessage.display("Deposit", "$" + amount + " has been deposited");
        this.setAccountLevel();
    }

    public void withdrawMoney(int amount){
        if(account.getBalance() >= amount){
            account.removeAmount(amount);
            //System.out.println("$" + amount + " Has been withdrawn\nYou new balance is $"+account.getBalance());
             UpdateMessage.display("Deposit", "$" + amount + " has been withdrawed"); 
            this.setAccountLevel();
        }
        else
             UpdateMessage.display("Deposit", "You do not have enough funds to withdraw $" +amount); 
            //System.out.println("You do not have enough funds to withdraw $" +amount );
    }
    public void onlinePurchase(int amount){
        if(amount < 50){
            UpdateMessage.display("Deposit", "Online purchase must be at least $50"); 
            return; }
        account.onlinePurchase(amount);
        this.setAccountLevel();
    }
    
    public void setAccountLevel(){ //private because only other methods in this class use it, no reason for it to be public
        int balance = account.getBalance();
        
        if(balance < 10000){
            account = new SilverMember();
            account.setBalance(balance);
        }
        if(balance >= 10000 && balance < 20000){
            account = new GoldMember();
            account.setBalance(balance);
        }       
        if(balance > 20000){
            account = new PlatinumMember();
            account.setBalance(balance);
        }
            
    }
    
    public String getAccountLevel(){
        setAccountLevel();
        return account.getAccountLevel();
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
