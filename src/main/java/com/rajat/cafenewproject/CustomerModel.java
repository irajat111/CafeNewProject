/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajat.cafenewproject;

/**
 *
 * @author i_rajat_1
*/

public class CustomerModel {
    private int id;
    private String name;
    private String email;
    private String contact;
    private String address;
    
    public CustomerModel(int id, String name,String email, String contact,String address){
        this.id= id;
        this.name = name;
        this.email = email;
        this.contact= contact;
        this.address = address;
    }
 

    public int getid(){
        return id;
    }

    public String getname(){
        return name;
    }
    
    public String getemail(){
        return email;
    }
    
    public String getcontact(){
        return contact;
    }
    
    public String getaddress(){
        return  address;
    }
}