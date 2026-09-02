/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajat.cafenewproject;

/**
 *
 * @author ASUS
 */
public class OrderItem {
    private int id;
    private  int customerId;
    private double totalPrice;

    public OrderItem(int id, int customerId, double totalPrice) {
        this.id = id;
        this.customerId = customerId;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
    
    
}
