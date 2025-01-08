/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

/**
 *
 * @author Julian Goncalves
 */
public class resistors {
    
    
private int ResistorNumber;
private int Node;
private int Node1;
private double ResistorValue;

public resistors(int ResistorNumber, int Node, int Node1, double ResistorValue){
    this.ResistorNumber = ResistorNumber;
    this.Node = Node;
    this.Node1 = Node1;
    this.ResistorValue = ResistorValue;
}
public String getResistor(){
    /*Prints number of resistor + nodes + value for spice*/
    String Resistor = "R"+ResistorNumber+" "+Node+" "+Node1+" "+ResistorValue; 
    return Resistor;
}
}
