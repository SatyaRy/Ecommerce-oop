import java.sql.Date;
import java.util.ArrayList;

public class Cart {
    private int cartId;
    private int customerId;
    private int sellerId;
    private Date createdDate;
    private ArrayList<Product> items;

    public Cart(int cartId, int customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.sellerId = 0; // Default sellerId, can be set later
        this.createdDate = new Date(System.currentTimeMillis());
        this.items = new ArrayList<>();
    }

    // Add product to cart
    public void addProduct(Product product) {
        items.add(product);
    }

    // Set sellerId
    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    // Getters
    public int getCartId() { return cartId; }
    public int getCustomerId() { return customerId; }
    public int getSellerId() { return sellerId; }
    public Date getCreatedDate() { return createdDate; }
    public ArrayList<Product> getItems() { return items; }

    // Show cart
    public void viewCart() {
        System.out.println("\n=== Cart Items ===");
        System.out.println("Created: " + createdDate);
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            for (Product p : items) {
                System.out.println("- " + p.getName() + ": $" + p.getPrice());
            }
            System.out.println("Total: $" + getTotalAmount());
        }
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }
}