☕ CafeNewProject — Cafe Management System

A desktop Cafe / Coffee Shop Management System built with Java Swing, backed by MySQL, and developed using the NetBeans GUI Builder. It allows an admin to log in and manage customers, menu items, staff, orders, and view coffee sales analytics through charts.

🧰 Tech Stack
Layer	Technology
Language	Java 24
GUI Framework	Java Swing (NetBeans GUI Builder / Matisse)
Layout Manager	NetBeans AbsoluteLayout
Build Tool	Maven
Database	MySQL (cafedb)
DB Connectivity	JDBC (mysql-connector-java 8.0.24)
Charts / Analytics	JFreeChart 1.5.5
📁 Project Structure
CafeNewProject/
├── pom.xml                     # Maven build config & dependencies
├── .gitignore
└── src/main/java/com/rajat/cafenewproject/
    ├── CafeNewProject.java      # 🚀 Main entry point (starts LoginForm)
    ├── Singleton.java           # 🔌 DB connection + auto table creation (Singleton pattern)
    │
    ├── LoginForm.java / .form   # 🔐 Admin login screen
    ├── DashboardNew.java / .form# 🏠 Main dashboard shell (sidebar navigation)
    │
    ├── Customer.java / .form    # 👤 Customer CRUD panel
    ├── CustomerModel.java       # 👤 Customer data model (POJO)
    │
    ├── Menuitem.java / .form    # 🍽️ Menu item CRUD panel
    ├── MenuModel.java           # 🍽️ Menu item data model (POJO)
    │
    ├── Staff.java / .form       # 🧑‍🍳 Staff CRUD panel
    ├── StaffModel.java          # 🧑‍🍳 Staff data model (POJO)
    │
    ├── Ordered.java / .form     # 🧾 Place/manage orders panel
    ├── OrderedModel.java        # 🧾 Order data model (POJO)
    ├── OrderItem.java           # 🧾 Single line-item within an order
    ├── OrderView.java / .form   # 📋 View placed orders / order details
    │
    └── CoffeeSales.java / .form # 📊 Sales analytics (JFreeChart graphs)
🏗️ Architecture Blueprint
                        ┌───────────────────────┐
                        │   CafeNewProject.java │   (main method)
                        │  entry point / launcher│
                        └───────────┬───────────┘
                                    │ opens
                                    ▼
                        ┌───────────────────────┐
                        │     LoginForm.java     │  ← validates admin
                        │ (Admin@gmail.com/123456)│    credentials
                        └───────────┬───────────┘
                                    │ on success
                                    ▼
                        ┌───────────────────────┐
                        │   DashboardNew.java    │  ← JFrame "shell"
                        │  (sidebar navigation)  │     swaps panels below
                        └───────────┬───────────┘
                                    │ loads one JPanel at a time
        ┌───────────┬──────────────┼──────────────┬───────────────┬──────────────┐
        ▼           ▼              ▼              ▼               ▼              ▼
   Customer.java Menuitem.java  Staff.java    Ordered.java    OrderView.java  CoffeeSales.java
   (JPanel)      (JPanel)       (JPanel)      (JPanel)        (JPanel)        (JPanel)
        │           │              │              │               │              │
        ▼           ▼              ▼              ▼               ▼              ▼
  CustomerModel  MenuModel    StaffModel    OrderedModel/    (reads Ordered   JFreeChart
    (POJO)        (POJO)       (POJO)       OrderItem (POJO)  + orderDetails)  visualization
        │           │              │              │               │              │
        └───────────┴──────────────┴──────────────┴───────────────┴──────────────┘
                                    │
                                    ▼
                        ┌───────────────────────┐
                        │    Singleton.java      │  ← single shared
                        │  (JDBC Connection)     │     MySQL connection
                        └───────────┬───────────┘
                                    ▼
                        ┌───────────────────────┐
                        │   MySQL: cafedb        │
                        └───────────────────────┘

Design pattern used: Singleton.java implements the Singleton pattern — one shared Connection object is reused across the whole app instead of opening a new DB connection every time. It also auto-creates all required tables on first run (CREATE TABLE IF NOT EXISTS ...), so the app is self-initializing as long as the cafedb database itself exists.

🗄️ Database Schema (auto-created by Singleton.java)
Table	Key Columns	Purpose
registered	id, email, password	Admin/user login records
customerTable	id, name, email, contact, address	Customer master data
MenuTable	id, Coffee, CoffeeType, Price, Category	Menu / coffee catalog
StaffTable	id, name, work, contact, address	Staff master data
OrderedTable	id, customerId (FK), customerName, totalPrice, orderDate	Order headers
orderDetailsTable	id, orderId (FK), menuId, coffeeName, type, quantity, category, price	Order line items

Relationships:

OrderedTable.customerId → customerTable.id
orderDetailsTable.orderId → OrderedTable.id
✨ Features
🔐 Admin Login — email/password validation with show/hide password toggle
🏠 Dashboard — central hub with sidebar navigation to all modules
👤 Customer Management — add/view/manage customer records
🍽️ Menu Management — add/view coffee menu items with category & pricing
🧑‍🍳 Staff Management — manage staff details
🧾 Order Management — create orders, add items, calculate totals
📋 Order View — view past orders and their details
📊 Sales Analytics — visual coffee sales charts via JFreeChart
⚙️ Setup & Run
Prerequisites
JDK 24
Maven
MySQL Server running locally on port 3306
Steps
Create the database (tables auto-create, but the DB itself must exist):
sql
   CREATE DATABASE cafedb;
Update DB credentials if needed in Singleton.java (currently root with no password):
java
   conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cafedb", "root", "");
Build the project:
bash
   mvn clean install
Run the app:
bash
   mvn exec:java -Dexec.mainClass="com.rajat.cafenewproject.CafeNewProject"

(or run CafeNewProject.java directly from your IDE)

Login credentials (hardcoded for demo):
Email: Admin@gmail.com
Password: 123456
🚧 Known Limitations / TODO
Login is hardcoded (Admin@gmail.com / 123456) — the registered table exists but sign-up/insert logic is currently commented out in LoginForm.java.
DB credentials (root, blank password) are hardcoded in Singleton.java — should be moved to a config file / environment variables.
No password hashing — passwords are stored/compared in plain text.
No unit tests included yet.
👤 Author

Rajat Singh (@irajat111)
