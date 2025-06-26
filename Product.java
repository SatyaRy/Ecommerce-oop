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

    // Static collection (shared across all instances)
    private static ArrayList<Product> products = new ArrayList<>();
    private static final String STORE_NAME = "Mini E-Shop"; // static constant

    // Constructor
    public Product(int productId, String name, String description,
                   double price, String category, String photo, int quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.photo = photo;
        this.quantity = quantity;
    }

    // Overloaded constructor (fewer fields)
    public Product(int productId, String name, double price) {
        this(productId, name, "No description", price, "General", "no-photo.jpg", 0);
    }

    // Getter methods (Encapsulation)
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getPhoto() { return photo; }
    public int getQuantity() { return quantity; }

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

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    createProduct(scanner);
                    break;
                case 2:
                    System.out.print("Enter Product ID to view: ");
                    int id = scanner.nextInt();
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

        scanner.close();
    }

    // Create product
    public static void createProduct(Scanner scanner) {
        System.out.println("\nEnter Product Details:");

        System.out.print("ID: ");
        int id = scanner.nextInt(); 
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Description: ");
        String desc = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble(); scanner.nextLine();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        System.out.print("Photo URL: ");
        String photo = scanner.nextLine();

        System.out.print("Quantity: ");
        int quantity = scanner.nextInt();

        Product newProduct = new Product(id, name, desc, price, category, photo, quantity);
        addProductToList(newProduct);

        System.out.println("✅ Product added successfully!");
    }
}