package Product;
import java.util.ArrayList;
// import java.util.Scanner;

public class Product {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int sellerId;

    private static ArrayList<Product> products = new ArrayList<>();
    private static String STORE_NAME = "Mini E-Shop for OOP Class";

    protected Product(String name, String description, double price, int quantity, int sellerId) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("Name is required");
        if (price < 0) throw new IllegalArgumentException("Price must be non-negative");
        if (quantity < 0) throw new IllegalArgumentException("Quantity must be non-negative");
        if (sellerId <= 0) throw new IllegalArgumentException("Seller ID must be positive");

        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.sellerId = sellerId;
    }

    protected String getName() { return name; }
    protected String getDescription() { return description; }
    protected double getPrice() { return price; }
    protected int getQuantity() { return quantity; }
    protected int getSellerId() { return sellerId; }

    public static void showWelcomeMessage() {
        System.out.println("Welcome to " + STORE_NAME);
    }

    protected void displayDetails() {
        System.out.println("\n--- Product Details ---");
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Seller ID: " + sellerId);
    }

    protected static void addProductToList(Product p) {
        products.add(p);
    }

    protected static void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product p : products) {
                p.displayDetails();
            }
        }
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price + ", sellerId=" + sellerId + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product other = (Product) obj;
        return name.equalsIgnoreCase(other.name) && sellerId == other.sellerId;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + sellerId;
    }
}
