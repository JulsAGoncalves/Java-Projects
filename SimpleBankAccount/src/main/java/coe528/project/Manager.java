/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.project;

/**
 *
 * @author Julian Goncalves
 */
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;












public class Manager {
    
    private String username = "Manager";
    private String password = "Admin";
    private String role = "manager";
    
    
   
    public Manager(){
       try{
            File loginInfo = new File(username + ".txt");
            if(loginInfo.createNewFile() == true){
                FileWriter writeToFile = new FileWriter(username + ".txt");
                writeToFile.write(username + "\n");
                writeToFile.write(password);
                writeToFile.close();
            }
        }catch(IOException e){
            System.out.println("IOException occured");
        }
 
    }
    
    public CustomerAccount addCustomer(String username, String password){
        return new CustomerAccount(username,password);
    }
    
    //Right now this exposes the rep, I probably need to change this shit
    public void deleteCustomer(CustomerAccount custToDelete){
        //First we must delete the text file, then point 
        File file = new File(custToDelete.getUsername() + ".txt");
        if(file.delete())
             UpdateMessage.display("Confirmation", "File successfully deleted");


        
        
    }
    
}
