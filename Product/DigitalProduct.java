package Product;

public class DigitalProduct extends Product {
    private int productId;
    private String photo;

    public DigitalProduct(int productId, String name, String description,
                          double price, String photo, int quantity, int sellerId) {
        super(name, description, price, quantity, sellerId);
        if (productId <= 0) throw new IllegalArgumentException("Product ID must be positive");

        this.productId = productId;
        this.photo = photo;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Product ID: " + productId);
        System.out.println("Category: Digital");
        System.out.println("Photo URL: " + photo);
    }

    @Override
    public String toString() {
        return super.toString() + ", DigitalProduct{ID=" + productId + ", category='Digital'}";
    }

    public int getProductId() { return productId; }
    public String getPhoto() { return photo; }
}
