

/*
 CS311 Project Milestone (1): Project Proposal of OOP1 Software
Project Group Number (2):
Section Number: Group (2)
Project Title is: E-Commerce Shopping Cart.


                   StudentID                                      Student Name

Leader            2230002567                             Munerah Khalid Alhassan
                  2210003313                             Bayan Qasim Alhamad
                  2230000760                             Falak Alshaheen
                  2220006563                             Fatimah Hassan
                  2230005744                             Fatimah Ishaq Albasri
                  2230005213                             Farah Alghamdi
Description:
The system will be designed to streamline online shopping experiences by leveraging object-oriented
programming principles in Java. Additionally, it will facilitate online shopping by allowing users to
browse products, add items to a virtual cart, and complete purchases.


Logical Analysis & Business
The e-commerce shopping cart system simplifies product management and checkout processes. Its main goals
are enhancing user experience and ensuring transaction security.



Logical Analysis:
" Product Management: Users can add, update, and remove items with real-time cart updates.
" Checkout Process: Secure payment and shipping processes with product availability checks.
Business Goals:
" User Retention: Improve customer loyalty with an easy shopping experience.
" Conversion Optimization: Reduce cart abandonment.
" Scalability: Support more users and products.
" Revenue Growth: Drive sales through promotions.


 */

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

// Product Class
class Product {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);
    private int id;
    private String name;
    private double price;
    private int stock;
    private String description;

    public Product(String name, double price, int stock, String description) {
        if (price < 0 || stock < 0) {
            throw new IllegalArgumentException("Invalid product values: price and stock must be positive.");
        }
        this.id = idGenerator.getAndIncrement();
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price +
                ", Stock: " + stock + ", Description: " + description);
    }

    // Overloading method
    public void displayDetails(boolean shortForm) {
        if (shortForm) {
            System.out.println("ID: " + id + ", Name: " + name + ", Price: $" + price);
        } else {
            displayDetails();
        }
    }

    // Example of shadowing variable
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price must be positive.");
        double shadowPrice = price; // Shadowing variable
        this.price = shadowPrice;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock must be positive.");
        this.stock = stock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return id == product.id; // Compare products by their unique ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Generate hash based on ID
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toCSV() {
        return id + "," + name + "," + price + "," + stock + "," + description;
    }

    public static Product fromCSV(String csv) {
        try {
            String[] parts = csv.split(",");
            return new Product(
                    parts[1],
                    Double.parseDouble(parts[2]),
                    Integer.parseInt(parts[3]),
                    parts[4]
            );
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error parsing product data: " + csv);
        }
    }
}

// Subclasses of Product
class Clothing extends Product {
    private String brand;
    private String size;
    private String material;
    private String gender;
    private String color;

    public Clothing(String name, double price, int stock, String description, String brand, String size, String material, String gender, String color) {
        super(name, price, stock, description);
        this.brand = brand;
        this.size = size;
        this.material = material;
        this.gender = gender;
        this.color = color;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Brand: " + brand + ", Size: " + size + ", Material: " + material +
                ", Gender: " + gender + ", Color: " + color);
    }

    // Overloading method
    public void displayDetails(boolean shortForm) {
        if (shortForm) {
            System.out.println("Brand: " + brand + ", Size: " + size + ", Price: $" + getPrice());
        } else {
            displayDetails();
        }
    }

    // Example of shadowing variable
    public void setBrand(String brand) {
        String shadowBrand = brand; // Shadowing variable
        this.brand = shadowBrand;
    }
}

class Electronics extends Product {
    private String brand;
    private int warrantyPeriod;

    public Electronics(String name, double price, int stock, String description, String brand, int warrantyPeriod) {
        super(name, price, stock, description);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Brand: " + brand + ", Warranty Period: " + warrantyPeriod + " months");
    }

    // Overloading method
    public void displayDetails(boolean shortForm) {
        if (shortForm) {
            System.out.println("Brand: " + brand + ", Price: $" + getPrice());
        } else {
            displayDetails();
        }
    }

    // Example of shadowing variable
    public void setWarrantyPeriod(int warrantyPeriod) {
        int shadowWarranty = warrantyPeriod; // Shadowing variable
        this.warrantyPeriod = shadowWarranty;
    }
}

class Books extends Product {
    private String author;
    private String publisher;
    private String ISBN;

    public Books(String name, double price, int stock, String description, String author, String publisher, String ISBN) {
        super(name, price, stock, description);
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Author: " + author + ", Publisher: " + publisher + ", ISBN: " + ISBN);
    }

    // Overloading method
    public void displayDetails(boolean shortForm) {
        if (shortForm) {
            System.out.println("Author: " + author + ", ISBN: " + ISBN + ", Price: $" + getPrice());
        } else {
            displayDetails();
        }
    }

    // Example of shadowing variable
    public void setAuthor(String author) {
        String shadowAuthor = author; // Shadowing variable
        this.author = shadowAuthor;
    }
}

class BeautyProducts extends Product {
    private String brand;
    private String skinType;
    private String expirationDate;
    private String ingredients;

    public BeautyProducts(String name, double price, int stock, String description, String brand, String skinType, String expirationDate, String ingredients) {
        super(name, price, stock, description);
        this.brand = brand;
        this.skinType = skinType;
        this.expirationDate = expirationDate;
        this.ingredients = ingredients;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Brand: " + brand + ", Skin Type: " + skinType +
                ", Expiration Date: " + expirationDate + ", Ingredients: " + ingredients);
    }

    // Overloading method
    public void displayDetails(boolean shortForm) {
        if (shortForm) {
            System.out.println("Brand: " + brand + ", Price: $" + getPrice());
        } else {
            displayDetails();
        }
    }

    // Example of shadowing variable
    public void setIngredients(String ingredients) {
        String shadowIngredients = ingredients; // Shadowing variable
        this.ingredients = shadowIngredients;
    }
}

// User Class
class User {
    protected String username;
    protected String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }

    public String getUsername() {
        return username;
    }
}

// Subclasses of User
class Customer extends User {
    private Cart cart;

    public Customer(String username, String password) {
        super(username, password);
        this.cart = new Cart();
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
        System.out.println("Product added to cart.");
    }

    public void checkout() {
        cart.calculateTotal();
        System.out.println("Checkout completed.");
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return super.login(inputUsername, inputPassword) && this.password.equals(inputPassword);
    }
}

class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addProduct(ArrayList<Product> productList, Product product) {
        if (!productList.contains(product)) { // Ensure the product is not already in the list
            productList.add(product);
            saveProductToFile(product); // Save the product to the file
            System.out.println("Product added and saved to file.");
        } else {
            System.out.println("Error: Product already exists in the list.");
        }
    }

    private void saveProductToFile(Product product) {
        try (PrintWriter out = new PrintWriter(new FileWriter("products.txt", true))) {
            out.println(product.toCSV());
        } catch (IOException e) {
            System.out.println("Error: Unable to save product to file.");
        }
    }

        public void deleteProduct(ArrayList<Product> productList, int productId) {
        Product product = Main.findProductById(productList, productId);
        if (product != null) {
            productList.remove(product); // Remove from the list
            Main.saveAllProductsToFile(); // Update the file
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Error: Product not found.");
        }
    }

    public void updateProduct(Product product, Scanner scanner) {
        try {
            System.out.print("Enter new name: ");
            product.setName(scanner.nextLine());
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();
            product.setPrice(newPrice);
            System.out.print("Enter new stock: ");
            int newStock = scanner.nextInt();
            product.setStock(newStock);
            scanner.nextLine(); // Consume newline
            System.out.print("Enter new description: ");
            String newDescription = scanner.nextLine();
            product.setDescription(newDescription);
            Main.saveAllProductsToFile(); // Update the file after modification
            System.out.println("Product updated successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }
}

// Cart Class
class Cart {
    private ArrayList<Product> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getId() == productId);
        System.out.println("Product removed from cart.");
    }

    public void calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        System.out.println("Total price: $" + total);
    }
}

// Main class to demonstrate functionality
public class Main {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "adminpass";
    private static final String SYSTEM_NAME = " Shopping Cart System";

    private static ArrayList<Product> clothingList = new ArrayList<>();
    private static ArrayList<Product> electronicsList = new ArrayList<>();
    private static ArrayList<Product> booksList = new ArrayList<>();
    private static ArrayList<Product> beautyProductsList = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    public static void printWelcomeMessage() {
    System.out.println("***********************************");
    System.out.println("*          Welcome to the         *");
    System.out.println("*        Shopping Cart System     *");
    System.out.println("*    We hope you enjoy your stay! *");
    System.out.println("***********************************\n");
}

    public static void main(String[] args) {
        printWelcomeMessage();
        loadProductsFromFile();
        loadUsersFromFile();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Select login type:");
                System.out.println("1. Admin");
                System.out.println("2. Customer");
                System.out.println("3. Exit");
                System.out.print("Choose an option: ");
                int loginChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (loginChoice) {
                case 1:
                    adminLogin(scanner);
                    break;
                case 2:
                    customerLogin(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Error: Invalid choice. Please try again.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void adminLogin(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\nAdmin Login:");
                System.out.println("1. Enter credentials");
                System.out.println("2. Go back to main menu");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Enter admin username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter admin password: ");
                    String password = scanner.nextLine();

                    if (username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD)) {
                        clearScreen();
                        System.out.println("Welcome to " + SYSTEM_NAME + ", " + username + "!");
                        adminActions(scanner);
                        break;
                    } else {
                        System.out.println("Error: Invalid admin credentials.");
                    }
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("Error: Invalid choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please try again.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void adminActions(Scanner scanner) {
        Admin admin = new Admin(ADMIN_USERNAME, ADMIN_PASSWORD);
        while (true) {
            try {
                System.out.println("\nAdmin Actions:");
                System.out.println("1. Add new product");
                System.out.println("2. Delete product");
                System.out.println("3. Update product");
                System.out.println("4. Exit");
                //System.out.print("Choose an option: ");

                int choice = getValidIntInput(scanner, "Choose an option: ");

                switch (choice) {
                case 1:
                case 2:
                case 3:
                    selectProductCategory(scanner, admin, choice);
                    break;
                case 4:
                    System.out.println("Exiting admin actions...");
                    return;
                default:
                    System.out.println("Error: Invalid choice.");
                    break;
                }
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }
    }

    private static int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private static void selectProductCategory(Scanner scanner, Admin admin, int actionChoice) {
        try {
            System.out.println("\nSelect Product Category:");
            System.out.println("1. Clothing");
            System.out.println("2. Electronics");
            System.out.println("3. Books");
            System.out.println("4. Beauty Products");
          //  System.out.print("Enter your choice: ");

            int categoryChoice = getValidIntInput(scanner, "Enter your choice: ");

            ArrayList<Product> selectedList;
            String categoryName;

            switch (categoryChoice) {
            case 1:
                selectedList = clothingList;
                categoryName = "Clothing";
                break;
            case 2:
                selectedList = electronicsList;
                categoryName = "Electronics";
                break;
            case 3:
                selectedList = booksList;
                categoryName = "Books";
                break;
            case 4:
                selectedList = beautyProductsList;
                categoryName = "Beauty Products";
                break;
            default:
                System.out.println("Error: Invalid category choice.");
                return;
            }

            displayCategoryProducts(selectedList, categoryName);

            switch (actionChoice) {
            case 1: // Add a new product
                addNewProduct(scanner, admin, selectedList, categoryChoice);
                break;
            case 2: // Delete a product
                System.out.print("Enter product ID to delete: ");
                int deleteId = getValidIntInput(scanner, "Enter product ID to delete: ");
                admin.deleteProduct(selectedList, deleteId);
                break;
            case 3: // Update a product
                System.out.print("Enter product ID to update: ");
                int updateId = getValidIntInput(scanner, "Enter product ID to update: ");
                Product product = findProductById(selectedList, updateId);
                if (product != null) {
                    admin.updateProduct(product, scanner);
                } else {
                    System.out.println("Error: Product not found.");
                }
                break;
            default:
                System.out.println("Error: Invalid action choice.");
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }

   private static void addNewProduct(Scanner scanner, Admin admin, ArrayList<Product> productList, int categoryChoice) {
    try {
        String name = getInput(scanner, "Enter product name: ");
        
        double price = getValidDoubleInput(scanner, "Enter product price: ");
        
        int stock = getValidIntInput(scanner, "Enter product stock: ");
        
        String description = getInput(scanner, "Enter product description: ");

        Product product = null;

        switch (categoryChoice) {
        case 1: // Clothing
            product = createClothing(scanner, name, price, stock, description);
            break;
        case 2: // Electronics
            product = createElectronics(scanner, name, price, stock, description);
            break;
        case 3: // Books
            product = createBooks(scanner, name, price, stock, description);
            break;
        case 4: // Beauty Products
            product = createBeautyProducts(scanner, name, price, stock, description);
            break;
        default:
            return;
        }

        if (product != null) {
            admin.addProduct(productList, product); // Add and save the product using Admin method
            saveAllProductsToFile(); // Save products to file
            System.out.println("Product added successfully!");
        }

    } catch (InputMismatchException e) {
        scanner.nextLine(); // Clear invalid input
    } catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }
}

private static String getInput(Scanner scanner, String prompt) {
    String input;
    while (true) {
        System.out.print(prompt);
        input = scanner.nextLine();
        if (!input.isBlank()) {
            break;
        }
    }
    return input;
}



    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = scanner.nextDouble();
                if (value < 0) {
                    throw new IllegalArgumentException("Value cannot be negative.");
                }
                scanner.nextLine(); // Consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static Product createClothing(Scanner scanner, String name, double price, int stock, String description) {
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter size: ");
        String size = scanner.nextLine();
        System.out.print("Enter material: ");
        String material = scanner.nextLine();
        System.out.print("Enter gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        return new Clothing(name, price, stock, description, brand, size, material, gender, color);
    }

    private static Product createElectronics(Scanner scanner, String name, double price, int stock, String description) {
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter warranty period (in months): ");
        int warrantyPeriod = getValidIntInput(scanner, "Warranty period (in months): ");
        return new Electronics(name, price, stock, description, brand, warrantyPeriod);
    }

    private static Product createBooks(Scanner scanner, String name, double price, int stock, String description) {
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.nextLine();
        return new Books(name, price, stock, description, author, publisher, ISBN);
    }

    private static Product createBeautyProducts(Scanner scanner, String name, double price, int stock, String description) {
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter skin type: ");
        String skinType = scanner.nextLine();
        System.out.print("Enter expiration date (YYYY-MM-DD): ");
        String expirationDate = scanner.nextLine();
        System.out.print("Enter ingredients: ");
        String ingredients = scanner.nextLine();
        return new BeautyProducts(name, price, stock, description, brand, skinType, expirationDate, ingredients);
    }

    private static void customerLogin(Scanner scanner) {
        while (true) {
            try {
                System.out.println("\nCustomer Login:");
                System.out.println("1. Sign in");
                System.out.println("2. Sign up");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 1) {
                    System.out.print("Enter your username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    Customer customer = findCustomerByUsername(username);
                    if (customer != null && customer.getPassword().equals(password)) {
                        System.out.println("Welcome to " + SYSTEM_NAME + ", " + customer.getUsername() + "!");
                        customerActions(scanner, customer);
                        break;
                    } else {
                        System.out.println("Error: Invalid username or password. Please try again.");
                    }
                } else if (choice == 2) {
                    System.out.print("Enter a new username: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Enter a new password: ");
                    String newPassword = scanner.nextLine();

                    if (findCustomerByUsername(newUsername) != null) {
                        System.out.println("Error: Username already exists. Please try a different one.");
                    } else {
                        Customer newCustomer = new Customer(newUsername, newPassword);
                        users.add(newCustomer);
                        saveUserToFile(newCustomer);
                        System.out.println("Account created successfully! Please log in.");
                    }
                } else {
                    System.out.println("Error: Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static Customer findCustomerByUsername(String username) {
        for (User user : users) {
            if (user instanceof Customer && user.getUsername().equals(username)) {
                return (Customer) user;
            }
        }
        return null;
    }

    private static void saveUserToFile(Customer customer) {
        try (PrintWriter out = new PrintWriter(new FileWriter("users.txt", true))) {
            out.println(customer.getUsername() + "," + customer.getPassword());
        } catch (IOException e) {
            System.out.println("Error: Unable to save user to file.");
        }
    }

    private static void customerActions(Scanner scanner, Customer customer) {
        boolean firstDisplay = false;

        while (true) {
            try {
                if (firstDisplay) {
                    System.out.println("Welcome to " + SYSTEM_NAME + ", " + customer.getUsername() + "!");
                    firstDisplay = false;
                }
                System.out.println("\nCustomer Actions:");
                System.out.println("1. Browse products");
                System.out.println("2. Add product to cart");
                System.out.println("3. Checkout");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                case 1:
                    browseProducts(scanner);
                    break;
                case 2:
                    addProductToCart(scanner, customer);
                    break;
                case 3:
                    customer.checkout();
                    break;
                case 4:
                    System.out.println("Exiting customer actions...");
                    return;
                default:
                    System.out.println("Error: Invalid choice.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static void browseProducts(Scanner scanner) {
        while (true) {
            System.out.println("\nBrowse Products:");
            System.out.println("1. View Clothing");
            System.out.println("2. View Electronics");
            System.out.println("3. View Books");
            System.out.println("4. View Beauty Products");
            System.out.println("5. View All Products");
            System.out.println("6. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
            case 1:
                displayCategoryProducts(clothingList, "Clothing");
                break;
            case 2:
                displayCategoryProducts(electronicsList, "Electronics");
                break;
            case 3:
                displayCategoryProducts(booksList, "Books");
                break;
            case 4:
                displayCategoryProducts(beautyProductsList, "Beauty Products");
                break;
            case 5:
                viewAllProducts();
                break;
            case 6:
                return;
            default:
                System.out.println("Error: Invalid choice.");
                break;
            }
        }
    }

    private static void viewAllProducts() {
        System.out.println("\n--- All Products ---");
        displayCategoryProducts(clothingList, "Clothing");
        displayCategoryProducts(electronicsList, "Electronics");
        displayCategoryProducts(booksList, "Books");
        displayCategoryProducts(beautyProductsList, "Beauty Products");
    }

    private static void displayCategoryProducts(ArrayList<Product> productList, String categoryName) {
        System.out.println("\n--- " + categoryName + " ---");
        if (productList.isEmpty()) {
            System.out.println("No products available in this category.");
        } else {
            for (Product product : productList) {
                product.displayDetails();
            }
        }
    }

    private static void addProductToCart(Scanner scanner, Customer customer) {
        try {
            System.out.print("Enter product ID to add to cart: ");
            int productId = scanner.nextInt();
            Product selectedProduct = findProductById(clothingList, productId);
            if (selectedProduct == null) selectedProduct = findProductById(electronicsList, productId);
            if (selectedProduct == null) selectedProduct = findProductById(booksList, productId);
            if (selectedProduct == null) selectedProduct = findProductById(beautyProductsList, productId);

            if (selectedProduct != null) {
                customer.addToCart(selectedProduct);
            } else {
                System.out.println("Error: Product not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid input. Please enter a number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    public static Product findProductById(ArrayList<Product> productList, int id) {
        for (Product product : productList) {
            if (product.getId() == id) return product;
        }
        return null;
    }

    private static void loadUsersFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    Customer customer = new Customer(parts[0], parts[1]);
                    users.add(customer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Info: No users found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error: Unable to load users.");
        }
    }

    public static void saveAllProductsToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter("products.txt"))) {
            for (Product product : clothingList) {
                out.println(product.toCSV());
            }
            for (Product product : electronicsList) {
                out.println(product.toCSV());
            }
            for (Product product : booksList) {
                out.println(product.toCSV());
            }
            for (Product product : beautyProductsList) {
                out.println(product.toCSV());
            }
        } catch (IOException e) {
            System.out.println("Error: Unable to save products to file.");
        }
    }

    private static void loadProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = Product.fromCSV(line);
                if (product instanceof Clothing) {
                    clothingList.add(product);
                } else if (product instanceof Electronics) {
                    electronicsList.add(product);
                } else if (product instanceof Books) {
                    booksList.add(product);
                } else if (product instanceof BeautyProducts) {
                    beautyProductsList.add(product);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Info: No products found. Starting fresh.");
        } catch (IOException e) {
            System.out.println("Error: Unable to load products.");
        }
    }
private static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}