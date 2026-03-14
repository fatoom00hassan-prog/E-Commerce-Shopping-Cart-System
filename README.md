# E-Commerce-Shopping-Cart-System

## Project Overview
The system is designed to streamline online shopping experiences by leveraging Object-Oriented Programming (OOP) principles in Java. It facilitates online shopping by allowing users to browse products, add items to a virtual cart, and complete purchases.

## Project Objectives & Goals

### . User Experience
To create a seamless and intuitive shopping experience for users by simplifying product management and checkout processes.

### Transaction Security
To ensure safe and reliable online transactions through secure payment and shipping methods.

## System Functionality

### Product Management
Users can add, update, and remove items from the cart with real-time updates.

### Checkout Process
Secure payment and shipping processes with real-time product availability checks.

### User Authentication
User sessions automatically expire after inactivity, enhancing security and protecting user data.

### Error Handling
Validation of payment and shipping information, input sanitization, and rate limiting are implemented to prevent misuse and ensure system reliability.

## System Users & Roles

### Customer
Customers can browse products, add items to the cart, and complete the checkout process.

### Administrator
Administrators can add, update, and delete products in the system.

## Object-Oriented Programming Concepts

This project demonstrates several key Object-Oriented Programming (OOP) principles:

### Encapsulation
Data and related methods are grouped together within classes to ensure better organization and data protection.

### Inheritance
Subclasses inherit attributes and behaviors from parent classes, allowing code reuse and better structure.

### Polymorphism
Methods can behave differently depending on the object type, enabling flexible and dynamic behavior.

### Abstraction
Complex functionality is simplified through well-structured classes that hide unnecessary implementation details.

## Main Classes

### Product
Represents a general product with attributes such as ID, name, price, stock, and description.

### User
Represents the general user structure with login credentials.

### Customer
A subclass of `User` that allows customers to browse products, add items to the cart, and complete purchases.

### Admin
A subclass of `User` responsible for managing products by adding, updating, and deleting them.

### Cart
Represents the shopping cart that stores selected products and calculates the total price.

