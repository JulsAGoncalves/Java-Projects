/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 *
 * @author Julian Goncalves
 */
public class PlatinumMember extends SimpleBankAccount {
    
     public void onlinePurchase(int amount){
         if(balance >= amount){
            balance -= amount;
          // System.out.println("You have made an online purchase of $" + amount);
                UpdateMessage.display("Platinum Member Purchase Confirmation", "You have made a purchase of $" + amount +"\nand with no additional service charge\nthe total cost is $" + (amount));
         }
         else
             UpdateMessage.display("Error Message", "You do not have the funds to make a puchase of $" + amount);
    }
     public String getAccountLevel(){
         return "You are a Platinum Member";
     }
    
}
