import java.util.ArrayList;

public class Cart {
    private int cartId;
    private int customerId;
    private ArrayList<Product> items;

    public Cart(int cartId, int customerId) {
        this.cartId = cartId;
        this.customerId = customerId;
        this.items = new ArrayList<>();
    }

    // Add product to cart
    public void addProduct(Product product) {
        items.add(product);
    }

    // Getters
    public int getCartId() { return cartId; }
    public int getCustomerId() { return customerId; }

    // Show cart
    public void viewCart() {
        System.out.println("\n=== Cart Items ===");
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
