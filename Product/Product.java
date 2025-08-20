// Product Main Class:
package Product;

import java.util.ArrayList;

public class Product {
    private String name;
    private String description;
    private double price;
    private int quantity;
    private int sellerId;

    private static ArrayList<Product> products = new ArrayList<>();
    private static String STORE_NAME = "Mini E-Shop for OOP Class";

    protected Product(String name, String description, double price, int quantity, int sellerId) {
        setName(name);
        setDescription(description);
        setPrice(price);
        setQuantity(quantity);
        setSellerId(sellerId);
    }

    // Getters
    public String getName() {
        if (name == null) throw new IllegalStateException("Product name is not set");
        return name;
    }

    protected String getDescription() {
        return description != null ? description : "No description available";
    }

    public double getPrice() {
        if (price < 0) throw new IllegalStateException("Invalid price state detected");
        return price;
    }

    protected int getQuantity() {
        if (quantity < 0) throw new IllegalStateException("Invalid quantity state detected");
        return quantity;
    }

    protected int getSellerId() {
        if (sellerId <= 0) throw new IllegalStateException("Invalid seller ID state detected");
        return sellerId;
    }

    // Setters
    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Product name cannot be null or empty");
        if (name.length() > 100) throw new IllegalArgumentException("Product name cannot exceed 100 characters");
        this.name = name.trim();
    }

    protected void setDescription(String description) {
        if (description != null && description.length() > 500)
            throw new IllegalArgumentException("Description cannot exceed 500 characters");
        this.description = description != null ? description.trim() : null;
    }

    protected void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        if (price > 999999.99) throw new IllegalArgumentException("Price cannot exceed $999,999.99");
        this.price = Math.round(price * 100.0) / 100.0;
    }

    protected void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        if (quantity > 100000) throw new IllegalArgumentException("Quantity cannot exceed 100,000 units");
        this.quantity = quantity;
    }

    protected void setSellerId(int sellerId) {
        if (sellerId <= 0) throw new IllegalArgumentException("Seller ID must be a positive integer");
        this.sellerId = sellerId;
    }

    public static void showWelcomeMessage() {
        System.out.println("Welcome to " + STORE_NAME);
    }

    public void displayDetails() {
        System.out.println("\n--- Product Details ---");
        System.out.println("Name: " + getName());
        System.out.println("Description: " + getDescription());
        System.out.println("Price: $" + getPrice());
        System.out.println("Quantity: " + getQuantity());
        System.out.println("Seller ID: " + getSellerId());
    }

    public static void addProductToList(Product p) {
        if (p == null) throw new IllegalArgumentException("Cannot add null product to list");
        products.add(p);
    }

    public static void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product p : products) {
                p.displayDetails();
                p.downloadOrShip(); // polymorphic method
            }
        }
    }

    public void downloadOrShip() {
        System.out.println("Processing product order...");
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