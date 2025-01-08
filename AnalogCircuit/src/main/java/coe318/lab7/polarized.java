/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab7;

/**
 *
 * @author Julian Goncalves
 */
public class polarized {
private int SourceNumber;
private int Node;
private int Node1;
private double SourceValue;

public polarized(int SourceNumber, int Node, int Node1, double SourceValue){
    this.SourceNumber = SourceNumber;
    this.Node = Node;
    this.Node1 = Node1;
    this.SourceValue = SourceValue;
}

public String getSource(){
    /*Prints number of source + nodes + value for spice*/
    String format = "V"+SourceNumber +" "+ Node + " "+ Node1 + " " + "DC"+ " "+SourceValue;
    return format;
}
}
