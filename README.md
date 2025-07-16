# Zoho_3rd_round
ATM Machine System Design
Documentation
Project Overview
This project is a Console-based ATM Machine Simulation implemented in Java.
It allows users to perform basic ATM transactions such as:

Checking account balance

Depositing money

Withdrawing money

Viewing customer details

The system mimics real-world ATM operations and uses object-oriented programming (OOP) principles for scalability and maintainability.

Key Features
Customer Management
Each user is represented as a Customer object with attributes like ID, name, PIN, and balance.

Transaction Operations
Supports withdrawal, deposit, and balance inquiry operations.

Secure PIN Authentication
Validates customer PIN before allowing transactions.

Multiple Customers Support
Handles multiple customers in a single program session.

Class Descriptions
1. Customer.java
Represents an individual bank customer.

Attributes:
Field	Type	Description
id	int	Customer ID
name	String	Customer's name
pin	int	Customer's ATM PIN
balance	double	Customer's account balance

Methods:
Method Name	Purpose
getId()	Returns customer ID
getName()	Returns customer name
getPin()	Returns customer PIN
getBalance()	Returns account balance
deposit(amount)	Adds money to balance
withdraw(amount)	Deducts money if balance allows

2. ATM.java
Handles the ATM operations and customer interactions.

Attributes:
Field	Type	Description
customers	List<Customer>	List of customers in the system

Methods:
Method Name	Purpose
addCustomer()	Adds new customer
findCustomerById()	Retrieves customer by ID
authenticate()	Checks PIN for authentication
deposit()	Handles deposit transactions
withdraw()	Handles withdrawal transactions
checkBalance()	Displays current balance
showCustomerDetails()	Displays customer information

3. Main.java
Entry point of the program.
Initializes the ATM object and manages the menu-driven console interface.

Responsibilities:
Display main menu

Handle user inputs

Invoke corresponding ATM operations

How It Works
Startup

The system initializes with predefined customers or allows adding new ones.

Authentication

Users input their ID and PIN to access their account.

Operations Menu

After successful login, users can:

Deposit money

Withdraw money

Check balance

View account details

Transaction Handling

Withdrawal and deposit operations adjust the balance accordingly.

Balance checks and account info retrieval are read-only.

Usage Instructions
Compile the Program:

bash
Copy
Edit
javac Customer.java ATM.java Main.java
Run the Program:

bash
Copy
Edit
java Main
Follow the Menu Prompts:

Enter Customer ID

Enter PIN

Choose desired operation

Example Menu (Console Output)
markdown
Copy
Edit
===== ATM Menu =====
1. Deposit
2. Withdraw
3. Check Balance
4. Show Customer Details
5. Exit
Enter your choice:
Possible Extensions
Connect to a real database (MySQL/PostgreSQL)

Implement transaction history logs

Add support for saving data in files or databases

GUI-based interface using JavaFX or Swing

Multi-threading for concurrent user handling

Summary
This project provides a simple yet functional ATM system simulation using Java's OOP capabilities.
It is suitable for learning purposes, practice with classes, objects, and basic banking operations.

License
This project is for educational purposes. No license restrictions applied unless specified.
