import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    // Private fields for encapsulation
    private int productId;
    private String name;
    private String description;
    private double price;
    private String category;
    private String photo;
    private int quantity;
    private int sellerId;

    // Static collection (shared across all instances)
    private static ArrayList<Product> products = new ArrayList<>();
    private static final String STORE_NAME = "Mini E-Shop for OOP Class"; // static constant

    // Constructor 
    public Product(int productId, String name, String description,
                   double price, String category, String photo, int quantity, int sellerId) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.photo = photo;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }

    // Overloaded constructor (without sellerId, defaults to 0)
    // public Product(int productId, String name, String description,
    //                double price, String category, String photo, int quantity) {
    //     this(productId, name, description, price, category, photo, quantity, 0);
    // }

    // Overloaded constructor (fewer fields)
    public Product(int productId, String name, double price) {
        this(productId, name, "No description", price, "General", "no-photo.jpg", 0, 0);
    }

    // Getter methods (Encapsulation)
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getPhoto() { return photo; }
    public int getQuantity() { return quantity; }
    public int getSellerId() { return sellerId; }

    // Static method to display store banner
    public static void showWelcomeMessage() {
        System.out.println("Welcome to " + STORE_NAME);
    }

    // Display details of a product (non-static)
    public void displayDetails() {
        System.out.println("\n--- Product Details ---");
        System.out.println("ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: $" + price);
        System.out.println("Category: " + category);
        System.out.println("Photo: " + photo);
        System.out.println("Quantity: " + quantity);
        System.out.println("Seller ID: " + sellerId);
    }

    // Add product to static collection
    public static void addProductToList(Product p) {
        products.add(p);
    }

    // View a product by ID
    public static void viewProductById(int id) {
        for (Product p : products) {
            if (p.getProductId() == id) {
                p.displayDetails();
                return;
            }
        }
        System.out.println("Product not found.");
    }

    // List all products
    public static void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product p : products) {
                p.displayDetails();
            }
        }
    }

    // Main product menu
    public static void productMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        showWelcomeMessage();

        while (running) {
            System.out.println("\n=== Product Management Menu ===");
            System.out.println("1. Add New Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. List All Products");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = readInt(scanner);

            switch (choice) {
                case 1:
                    createProduct(scanner);
                    break;
                case 2:
                    System.out.print("Enter Product ID to view: ");
                    int id = readInt(scanner);
                    viewProductById(id);
                    break;
                case 3:
                    listAllProducts();
                    break;
                case 0:
                    System.out.println("Exiting Product Management...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        // Do not close scanner tied to System.in
    }

    // Create product
    public static void createProduct(Scanner scanner) {
        System.out.println("\nEnter Product Details:");

        System.out.print("ID: ");
        int id = readInt(scanner);

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Price: ");
        double price = readDouble(scanner);

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Photo URL: ");
        String photo = scanner.nextLine();

        System.out.print("Quantity: ");
        int quantity = readInt(scanner);

        System.out.print("Seller ID: ");
        int sellerId = readInt(scanner);

        Product newProduct = new Product(id, name, desc, price, category, photo, quantity, sellerId);
        addProductToList(newProduct);

        System.out.println("✅ Product added successfully!");
    }

    // Helper method for safe integer input
    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter an integer: ");
            }
        }
    }

    // Helper method for safe double input
    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                double value = Double.parseDouble(scanner.nextLine());
                return value;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}