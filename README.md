# E-Commerce-Shopping-Cart-System

## Project Overview
The system is designed to streamline online shopping experiences by leveraging Object-Oriented Programming (OOP) principles in Java. It facilitates online shopping by allowing users to browse products, add items to a virtual cart, and complete purchases.

## Project Objectives & Goals

### User Experience
- Create a seamless and intuitive shopping experience for users.
- Simplify product management and checkout processes.

### Transaction Security
- Ensure safe and reliable online transactions.
- Support secure payment and shipping methods.

## System Functionality

### Product Management
- Add products to the system.
- Update existing product information.
- Remove items from the cart with real-time updates.

### Checkout Process
- Secure payment and shipping processes.
- Real-time product availability checks.

### User Authentication
- User login system.
- Sessions automatically expire after inactivity to enhance security.

### Error Handling
- Validation of payment and shipping information.
- Input sanitization to prevent invalid data.
- Rate limiting to prevent misuse.

## System Users & Roles

### Customer
- Browse available products.
- Add products to the shopping cart.
- Remove items from the cart.
- Complete the checkout process.

### Administrator
- Add new products.
- Update product information.
- Delete products from the system.

## Object-Oriented Programming Concepts

This project demonstrates several key Object-Oriented Programming (OOP) principles:

### Encapsulation
- Data and related methods are grouped within classes.
- Ensures better organization and data protection.

### Inheritance
- Subclasses inherit attributes and behaviors from parent classes.
- Improves code reuse and system structure.

### Polymorphism
- Methods behave differently depending on the object type.
- Enables flexible and dynamic behavior.

### Abstraction
- Complex functionality is simplified through structured classes.
- Implementation details are hidden from the user.

## Main Classes

### Product
- Represents a general product.
- Contains attributes such as ID, name, price, stock, and description.

### User
- Represents system users.
- Contains login credentials.

### Customer
- A subclass of `User`.
- Allows browsing products, adding items to the cart, and completing purchases.

### Admin
- A subclass of `User`.
- Responsible for adding, updating, and deleting products.

### Cart
- Represents the shopping cart.
- Stores selected products.
- Calculates the total price of items.

