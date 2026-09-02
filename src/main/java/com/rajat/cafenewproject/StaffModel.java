/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajat.cafenewproject;

/**
 *
 * @author i_rajat_1
 */
public class StaffModel {
    private int id;
    private String Name;
    private String Work;
    private String Contact;
    private String Address;
    
    public StaffModel(int id, String Name, String Work, String Contact, String Address){
        this.id = id;
        this.Name = Name;
        this.Work = Work;
        this.Contact = Contact;
        this.Address = Address;
    }
    
    public int getid(){
    return id;
    }
    
    public String getName(){
    return Name;
    }
    
    public String getWork(){
    return Work;
    }
    
    public String getContact(){
    return Contact;
    }
    
    public String getAddress(){
    return Address;
    }
}
