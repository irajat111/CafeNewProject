/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajat.cafenewproject;

/**
 *
 * @author i_rajat_1
 */
public class MenuModel {
    private int id;
    private String Coffee;
    private String CoffeeType;
    private String Price;
    private String Category;
    
    public MenuModel(int id, String Coffee,String CoffeeType, String Price,String Category){
        this.id= id;
        this.Coffee = Coffee;
        this.CoffeeType = CoffeeType;
        this.Price = Price;
        this.Category = Category;
    }
    
    
    public int getid(){
        return id;
    }
    
    public String getCoffee(){
        return Coffee;
    }
    
    public String getCoffeeType(){
        return CoffeeType;
    }
    
    public String getPrice(){
        return Price;
    }
    
    public String getCategory(){
        return  Category;
    }
    
    
}