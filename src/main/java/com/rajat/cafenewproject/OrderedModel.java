/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajat.cafenewproject;

/**
 *
 * @author i_rajat_1
 */
public class OrderedModel {
    private int menuId;
    private String Coffee;
    private String Type;
    private int quantity;
    private String Category;
    private double  Price;
    
    public OrderedModel(int menuId, String Coffee, String Type, int quantity, double Price, String Category){
        this.menuId = menuId;
     
        this.Coffee = Coffee;
        this.Type = Type;
        this.quantity = quantity;
        this.Category = Category;
        this.Price = Price;
    }
    
    public int getid(){
        return menuId;
    }
    
  
    
    public String getCoffee(){
        return Coffee;
    }
    
    public String getType(){
        return Type;
    }
     public int getQuantity(){
        return quantity;
    }
     
     public void setQuantity(int quantity){
       this.quantity = quantity;
    }
    
    public String getCategory(){
        return Category;
    }
    
   
    
    public double getPrice(){
        return Price;
    }
}