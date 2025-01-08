/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package coe318.lab7;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Julian Goncalves
 */
public class UserMain {
private ArrayList<resistors> resistors;
private ArrayList<polarized> polarized; 
    

 public UserMain(){
resistors = new ArrayList<resistors>(); 
polarized = new ArrayList<polarized>(); 
}
 
public void addResistor(resistors res){
    resistors.add(res);
}

public void addPolarized(polarized d){
    polarized.add(d);
}
    public static void main(String[] args) {
        UserMain userMain = new UserMain();
        Scanner scanner = new Scanner(System.in);
        
        String end = "";
        int ResistorNumber = 1; //atleast 1 resistor
        int SourceNumber = 1; //atleast 2 sources
        
        while(end != "end"){
        System.out.println(" Enter an Electrical Compnent:  ");
        String input = scanner.nextLine();
        
        String[] component = input.split("\\s+"); /*Utilising whitespace as the 
        delimiter, divide the input string.*/
        // pretty much dividing the inputs based on empty spaces

        if (component.length == 4) { /*4 because you can only have 4 variables
            example: r 1 2 0.25 that's 4 variables*/
            String letter = component[0];
            int Node = Integer.parseInt(component[1]);
            int Node1 = Integer.parseInt(component[2]);
            double Value = Double.parseDouble(component[3]);
            
            if (letter.equals("r")) {
                    resistors resistor = new resistors(ResistorNumber, Node, Node1, Value);
                    userMain.addResistor(resistor);
                    ResistorNumber++;
                }
            
            if (letter.equals("v")) {
                    polarized source = new polarized(SourceNumber, Node, Node1, Value);
                    userMain.addPolarized(source);
                    SourceNumber++;
                }
                     
        }else if("spice".equals(component[0])) {
         
         for (resistors resistor : userMain.resistors) {
                    System.out.println(resistor.getResistor());
            
         }
         for (polarized source : userMain.polarized){
             System.out.println(source.getSource());
         }
         
        }else if("end".equals(component[0])){
         System.out.println("All Done");
         break;
         
        }else{
         System.out.println("Error");    
        }
       
    }
    }
}
