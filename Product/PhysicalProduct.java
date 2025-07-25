package Product;

public class PhysicalProduct extends Product {
    private int productId;
    private String category;
    private String photo;

    public PhysicalProduct(int productId, String name, String description,
                           double price, String category, String photo,
                           int quantity, int sellerId) {
        super(name, description, price, quantity, sellerId);
        if (productId <= 0) throw new IllegalArgumentException("Product ID must be positive");
        if (category == null || category.isEmpty()) throw new IllegalArgumentException("Category required");

        this.productId = productId;
        this.category = category;
        this.photo = photo;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Product ID: " + productId);
        System.out.println("Category: " + category);
        System.out.println("Photo URL: " + photo);
    }

    @Override
    public String toString() {
        return super.toString() + ", PhysicalProduct{ID=" + productId + ", category='" + category + "'}";
    }

    public int getProductId() { return productId; }
    public String getCategory() { return category; }
    public String getPhoto() { return photo; }
}
