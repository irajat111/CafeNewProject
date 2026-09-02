/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.rajat.cafenewproject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author i_rajat_1
 */
public class Ordered extends javax.swing.JPanel {
ArrayList<MenuModel> Menulist = new ArrayList<>();
ArrayList<CustomerModel> custmerlist = new ArrayList<>();
 double totalPrice = 0.0;
    /**
     * Creates new form Ordered
     */
    
    Singleton con = Singleton.Display();
    ArrayList<OrderedModel> Orderedlist = new ArrayList<>();

    public Ordered() {
        initComponents();
        getTable();
        getCustomer();
        
    }
    void getOrderData(){
        String header[] = {"MenuId","CoffeeName","Type","Quantity","Category","Price"};
        DefaultTableModel model = new DefaultTableModel(null,header);
        OrderedTable.setModel(model);
        model.setRowCount(0);
        Object[] row = new Object[6];
          totalPrice =0.0;
      for(OrderedModel item: Orderedlist){
            row[0] = item.getid();
            row[1] = item.getCoffee();
            row[2] = item.getType();
            row[3] = item.getQuantity();
            row[4] = item.getCategory();
            row[5] = item.getPrice();
            model.addRow(row);
      }
      for(int i =0; i< Orderedlist.size(); i++){
    totalPrice += Orderedlist.get(i).getQuantity() * Orderedlist.get(i).getPrice(); // ✅ price * quantity
      
      }
      showTotalPrice.setText(String.valueOf(totalPrice));
    }
     void getCustomer(){
        try{
          
            DefaultComboBoxModel<String> combo = new DefaultComboBoxModel();
            String getQuerry = "SELECT * FROM customerTable";
            Statement obj = con.conn.createStatement();
            ResultSet resultobj1 = obj.executeQuery(getQuerry);
            // custmerlist.clear();
             
             while(resultobj1.next()){
             CustomerModel customer = new CustomerModel(
                     resultobj1.getInt("id"),
                     resultobj1.getString("name"),
                     resultobj1.getString("email"),
                     resultobj1.getString("contact"),
                     resultobj1.getString("address")
             );
             custmerlist.add(customer);
             combo.addElement(customer.getname());
////             
             }
             
             customerMenu.setModel(combo);
             
           
        }catch(SQLException exception){
           System.out.println("Check Excepiton: "+exception);
        }
    }
      void getTable(){
        try{
            String MenuHeader[] = {"id","Coffee","CoffeeType","Price","Category"};
            DefaultTableModel Model = new DefaultTableModel(null,MenuHeader);
            MenuTable.setModel(Model);
            Model.setRowCount(0);
            
            String getQuerry = "SELECT * FROM Menutable ";
            Statement obj = con.conn.createStatement();
            ResultSet resultobj = obj.executeQuery(getQuerry);
             Menulist.clear();
             
             while(resultobj.next()){
             Menulist.add(new MenuModel(
                     resultobj.getInt("id"),
                     resultobj.getString("Coffee"),
                     resultobj.getString("CoffeeType"),
                     resultobj.getString("Price"),
                     resultobj.getString("Category")
             ));             
             }
             
             Object[] row = new Object[5];
             
             for(MenuModel itemVar : Menulist){
                 row[0] = itemVar.getid();
                 row[1] = itemVar.getCoffee();
                 row[2] = itemVar.getCoffeeType();      // CoffeeTypes
                 row[3] = itemVar.getPrice();
                 row[4] = itemVar.getCategory();
                 Model.addRow(row);
             }   
             
           
             
        }catch(SQLException exception){
           System.out.println("Check Excepiton: "+exception);
        }
        
    }

//    void getTable(){
//        try{
//            String OrderedHeader[] = {"id","CName","Coffee","Type","Category","Quantity","Price"};
//            DefaultTableModel Model = new DefaultTableModel(null,OrderedHeader);
//            OrderedTable.setModel(Model);
//            Model.setRowCount(0);
//            
//            String getQuerry = "SELECT * FROM OrderedTable ";
//            Statement obj = con.conn.createStatement();
//            ResultSet resultobj = obj.executeQuery(getQuerry);
//             Orderedlist.clear();
//             
//             while(resultobj.next()){
//                Orderedlist.add(new OrderedModel(
//                     resultobj.getInt("id"),
//                     resultobj.getString("CName"),
//                     resultobj.getString("Coffee"),
//                     resultobj.getString("Type"),
//                     resultobj.getString("Category"),
//                     resultobj.getString("Quantity"),
//                     resultobj.getString("Price") 
//                ));             
//             }
//             
//             
//             Object[] row = new Object[7];
//             
//             for(OrderedModel itemVar : Orderedlist){
//                 row[0] = itemVar.getid();
//                 row[1] = itemVar.getCName();
//                 row[2] = itemVar.getCoffee();      // CoffeeTypes
//                 row[3] = itemVar.getType();
//                 row[4] = itemVar.getCategory();
//                 row[5] = itemVar.getQuantity();
//                 row[6] = itemVar.getPrice();
//                 Model.addRow(row);
//             }   
//             
//        }catch(SQLException exception){
//           System.out.println("Check Excepiton: "+exception);
//        }
//        
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OrederdPanel = new javax.swing.JPanel();
        OrderedLabel = new javax.swing.JLabel();
        VarPanel = new javax.swing.JPanel();
        CNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderedTable = new javax.swing.JTable();
        Updatebtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        MenuTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        showTotalPrice = new javax.swing.JTextField();
        customerMenu = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(630, 530));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrederdPanel.setBackground(new java.awt.Color(0, 140, 140));
        OrederdPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        OrderedLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        OrderedLabel.setForeground(new java.awt.Color(255, 236, 209));
        OrderedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OrderedLabel.setText("Ordered");
        OrederdPanel.add(OrderedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 630, 40));

        add(OrederdPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 59));

        VarPanel.setPreferredSize(new java.awt.Dimension(820, 600));
        VarPanel.setRequestFocusEnabled(false);

        CNameLabel.setBackground(new java.awt.Color(255, 255, 255));
        CNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CNameLabel.setText("Customer Name");

        OrderedTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        OrderedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "menuId", "Coffee", "Type", "Category", "Quantity", "Price"
            }
        ));
        OrderedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrderedTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OrderedTable);

        Updatebtn.setBackground(new java.awt.Color(0, 140, 140));
        Updatebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Updatebtn.setForeground(new java.awt.Color(255, 236, 209));
        Updatebtn.setText("ORDER");
        Updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdatebtnActionPerformed(evt);
            }
        });

        MenuTable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        MenuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Coffee", "Coffee Type", "Price", "Category"
            }
        ));
        MenuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(MenuTable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Total Amount");

        showTotalPrice.setEditable(false);
        showTotalPrice.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        customerMenu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Order Table");

        javax.swing.GroupLayout VarPanelLayout = new javax.swing.GroupLayout(VarPanel);
        VarPanel.setLayout(VarPanelLayout);
        VarPanelLayout.setHorizontalGroup(
            VarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VarPanelLayout.createSequentialGroup()
                .addGroup(VarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(VarPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2))
                    .addGroup(VarPanelLayout.createSequentialGroup()
                        .addGroup(VarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VarPanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(CNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(customerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VarPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(showTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Updatebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105))
        );
        VarPanelLayout.setVerticalGroup(
            VarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VarPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(VarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CNameLabel)
                    .addComponent(customerMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(VarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Updatebtn)
                    .addComponent(showTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        add(VarPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 630, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void MenuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuTableMouseClicked
        // TODO add your handling code here:

        int row = MenuTable.getSelectedRow();
        Object valueId = MenuTable.getValueAt(row, 0);
        Object valueCoffee = MenuTable.getValueAt(row, 1);
        Object valueCoffeeType  = MenuTable.getValueAt(row, 2);
        Object valuePrice = MenuTable.getValueAt(row, 3);
        Object valueCategory = MenuTable.getValueAt(row, 4);
        int menuId = Integer.parseInt(valueId.toString());
        String coffeeName = String.valueOf(valueCoffee);
        String coffeeType = String.valueOf(valueCoffeeType);
        double coffeePrice = Double.parseDouble(valuePrice.toString());
        String category = String.valueOf(valueCategory);

        Orderedlist.add(new OrderedModel(menuId,coffeeName,coffeeType,1,coffeePrice,category));
        getOrderData();
    }//GEN-LAST:event_MenuTableMouseClicked

    private void UpdatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdatebtnActionPerformed
       DefaultTableModel defaultModel = (DefaultTableModel) OrderedTable.getModel();

    if (defaultModel.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "Order table is empty!");
        return;
    }

    for (int row = 0; row < defaultModel.getRowCount(); row++) {
        for (int col = 0; col < defaultModel.getColumnCount(); col++) {
            if (defaultModel.getValueAt(row, col) == null) {
                JOptionPane.showMessageDialog(
                        this,
                        "Order table contains empty fields! Please check row " + (row + 1)
                );
                return;
            }
        }
    }

    int index = customerMenu.getSelectedIndex();
    CustomerModel Cmodel = custmerlist.get(index);
    String cName = Cmodel.getname();
    int cId = Cmodel.getid();

    String insertOrderQuery =
            "INSERT INTO OrderedTable (customerId, customerName, totalPrice) VALUES (?, ?, ?)";

    try {

       
        PreparedStatement pst2 = con.conn.prepareStatement(
                insertOrderQuery,
                Statement.RETURN_GENERATED_KEYS
        );
        pst2.setInt(1, cId);
        pst2.setString(2, cName);
        pst2.setDouble(3, totalPrice);
        pst2.executeUpdate();

        ResultSet generatedKeys = pst2.getGeneratedKeys();
        int orderId = -1;

        if (generatedKeys.next()) {
            orderId = generatedKeys.getInt(1);
        }

    
        for (int i = 0; i < defaultModel.getRowCount(); i++) {

            int menuId = Integer.parseInt(defaultModel.getValueAt(i, 0).toString());
            String coffee = defaultModel.getValueAt(i, 1).toString();
            String type = defaultModel.getValueAt(i, 2).toString();
            int quantity = Integer.parseInt(defaultModel.getValueAt(i, 3).toString());
            String category = defaultModel.getValueAt(i, 4).toString();
            double price = Double.parseDouble(defaultModel.getValueAt(i, 5).toString());

            String insertDetailQuery =
                    "INSERT INTO orderDetailsTable (orderId, menuId, coffeeName, type, quantity, category, price) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst3 = con.conn.prepareStatement(insertDetailQuery);
            pst3.setInt(1, orderId);
            pst3.setInt(2, menuId);
            pst3.setString(3, coffee);
            pst3.setString(4, type);
            pst3.setInt(5, quantity);
            pst3.setString(6, category);
            pst3.setDouble(7, price);
            pst3.executeUpdate();
        }

      
        JOptionPane.showMessageDialog(this, "Order placed successfully!");

        Orderedlist.clear();
        defaultModel.setRowCount(0);
        showTotalPrice.setText("");

    } catch (SQLException ex) {
        System.getLogger(Ordered.class.getName())
                .log(System.Logger.Level.ERROR, (String) null, ex);
    }


    }//GEN-LAST:event_UpdatebtnActionPerformed

    private void OrderedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrderedTableMouseClicked

        String[] options = {"Update", "Delete"};

        int choice = JOptionPane.showOptionDialog(
            this,
            "Do you want to update or delete",
            "Confirm Order",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0] 
        );
        if (choice == 0) {
            int selectedRow = OrderedTable.getSelectedRow();  
            if (selectedRow >= 0 && selectedRow < Orderedlist.size()) {
                OrderedModel selectedOrder = Orderedlist.get(selectedRow);

                String newQuantityStr = JOptionPane.showInputDialog(this, "Enter Quantity", selectedOrder.getQuantity());

                if (newQuantityStr != null && !newQuantityStr.trim().isEmpty()) {
                    try {
                        int newQuantity = Integer.parseInt(newQuantityStr);
                        if (newQuantity > 0) {
                            selectedOrder.setQuantity(newQuantity);

                            DefaultTableModel model = (DefaultTableModel) OrderedTable.getModel();
                            model.setValueAt(newQuantity, selectedRow, 3); 
                            totalPrice = 0.0;
                            for(int i =0; i< Orderedlist.size(); i++){
                                totalPrice += Orderedlist.get(i).getQuantity() * Orderedlist.get(i).getPrice();

                            }
                            showTotalPrice.setText(String.valueOf(totalPrice));
                        } else {
                            JOptionPane.showMessageDialog(this, "Quantity must be greater than 0");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Invalid number format");
                    }
                }
            }

        } else if (choice == 1) {
            int selectedRow = OrderedTable.getSelectedRow();
            Orderedlist.remove(selectedRow);

            DefaultTableModel model = (DefaultTableModel) OrderedTable.getModel();
            model.removeRow(selectedRow); 

            totalPrice = 0.0;
            for (OrderedModel item : Orderedlist) {
                totalPrice += item.getQuantity() * item.getPrice();
            }
            showTotalPrice.setText(String.valueOf(totalPrice));

            JOptionPane.showMessageDialog(this, "Item deleted successfully!");

        }

    }//GEN-LAST:event_OrderedTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CNameLabel;
    private javax.swing.JTable MenuTable;
    private javax.swing.JLabel OrderedLabel;
    private javax.swing.JTable OrderedTable;
    private javax.swing.JPanel OrederdPanel;
    private javax.swing.JButton Updatebtn;
    private javax.swing.JPanel VarPanel;
    private javax.swing.JComboBox<String> customerMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField showTotalPrice;
    // End of variables declaration//GEN-END:variables
}
