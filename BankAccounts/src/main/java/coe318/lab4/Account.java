/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;

/**
 *
 * @author Julian Goncalves
 */
public class Account {
    
    private String name2;
    private int number;
    private double balance;
    
    public Account(String Name, int Number, double Amount){
        
        name2 = Name;
        number = Number;
        balance = Amount;
        
    }
    
    public String getName(){
        return name2;
    }
    
    public double getBalance(){
        return balance;
    }
    
    public int getNumber(){
        return number;
    }
    
    public boolean deposit(double amount){
        
        if(amount <= 0){
            return false;
        }else
            balance = balance + amount;
        return true;
        
    }
    
    public boolean withdraw(double amount){
        
        if(amount > balance){
            return false;
        }else if(amount <= 0){
            return false;
        }else
            balance = balance - amount;
        return true;
        
    }
    
    @Override
public String toString() {//DO NOT MODIFY
return "(" + getName() + ", " + getNumber() + ", " +
String.format("$%.2f", getBalance()) + ")";
}
    
}
