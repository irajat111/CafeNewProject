/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rajat.cafenewproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author i_rajat_1
 */
public class Singleton {
    
// jdbc:mysql://localhost:3306/cafedb?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
private static Singleton instance = null;
Connection conn = null;    
//jdbc:mysql://localhost:3306/cafedb?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]
private Singleton(){
try{
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb","root","");
    if(conn != null ){
       String createStudent = "CREATE TABLE IF NOT EXISTS registered (" +
        "id INT AUTO_INCREMENT," +
        "email VARCHAR(255), " +
        "password VARCHAR(255), " +
        "PRIMARY KEY(id))";
        PreparedStatement ps = conn.prepareStatement(createStudent);
         ps.execute();
            
         String registered = "CREATE TABLE IF NOT EXISTS customerTable (" +
        "id INT AUTO_INCREMENT," +
         "name VARCHAR(255), " +
        "email VARCHAR(255), " +
        "contact VARCHAR(255), " +
        "address VARCHAR(255), " +
        "PRIMARY KEY(id))";
        PreparedStatement pss = conn.prepareStatement(registered);
         pss.execute();

         
         String MenuTable = "CREATE TABLE IF NOT EXISTS MenuTable(" +
    "id INT AUTO_INCREMENT, " +
    "Coffee VARCHAR(255), " +
    "CoffeeType VARCHAR(255), " +
    "Price DOUBLE,"+  
     "Category VARCHAR(255),"+
    "PRIMARY KEY(id))";

         
         PreparedStatement pss2 = conn.prepareStatement(MenuTable);
         pss2.execute();
         
            // these names show in xampp db
         String StaffTable = "CREATE TABLE IF NOT EXISTS StaffTable(" +
             "id INT AUTO_INCREMENT, " +  
             "name VARCHAR(255), " +
             "work VARCHAR(255), " +
             "contact VARCHAR(255), " +
             "address VARCHAR(255), " +
             "PRIMARY KEY(id))";
             
             PreparedStatement stfps = conn.prepareStatement(StaffTable);
                stfps.execute();
                
            
          String OrderedTable = "CREATE TABLE IF NOT EXISTS OrderedTable (" +
   "id INT AUTO_INCREMENT, " +
   "customerId INT, " +
   "customerName VARCHAR(100), " +
   "totalPrice DOUBLE, " +
   "orderDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP, " +
   "PRIMARY KEY(id), " +
   "FOREIGN KEY (customerId) REFERENCES customerTable(id))";

               
           
             PreparedStatement orderps = conn.prepareStatement(OrderedTable);
                    orderps.execute();
                    
                      
          String orderDetailsTable = "CREATE TABLE IF NOT EXISTS orderDetailsTable (" +
   "id INT AUTO_INCREMENT, " +
   "orderId INT, " +
   "menuId INT, " +
   "coffeeName VARCHAR(100), " +
   "type VARCHAR(50), " +
   "quantity INT, " +
   "category VARCHAR(50), " +
   "price DOUBLE, " +
   "PRIMARY KEY(id), " +
   "FOREIGN KEY (orderId) REFERENCES OrderedTable(id))";

               
           
             PreparedStatement orderDetails = conn.prepareStatement(orderDetailsTable);
                    orderDetails.execute();
                    
                   
           
         }
        }   catch(SQLException e){
            System.out.println(e);
        }
        }

public static Singleton Display(){ 
    if(instance == null){
    instance = new Singleton();
    }   
        return instance;
}      
}
