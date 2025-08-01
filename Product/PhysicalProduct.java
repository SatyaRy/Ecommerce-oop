package Product;

public class PhysicalProduct extends Product {
    private int productId;
    private String category;
    private String photo;

    public PhysicalProduct(int productId, String name, String description,
                           double price, String category, String photo,
                           int quantity, int sellerId) {
        super(name, description, price, quantity, sellerId);
        setProductId(productId);
        setCategory(category);
        setPhoto(photo);
    }

    public int getProductId() {
        if (productId <= 0) throw new IllegalStateException("Invalid product ID state detected");
        return productId;
    }

    public String getCategory() {
        if (category == null || category.trim().isEmpty()) throw new IllegalStateException("Product category not properly set");
        return category;
    }

    public String getPhoto() {
        return photo != null ? photo : "No photo available";
    }

    public void setProductId(int productId) {
        if (productId <= 0 || productId > 999999)
            throw new IllegalArgumentException("Product ID must be between 1 and 999,999");
        this.productId = productId;
    }

    public void setCategory(String category) {
        if (category == null || category.trim().isEmpty())
            throw new IllegalArgumentException("Category cannot be null or empty");
        if (category.length() > 50)
            throw new IllegalArgumentException("Category cannot exceed 50 characters");

        String[] allowedCategories = {"Electronics", "Clothing", "Books", "Home", "Sports", "Toys", "Beauty", "Food", "Other"};
        String trimmed = category.trim();
        boolean valid = false;
        for (String c : allowedCategories) {
            if (c.equalsIgnoreCase(trimmed)) {
                this.category = c;
                valid = true;
                break;
            }
        }
        if (!valid) throw new IllegalArgumentException("Invalid category.");
    }

    public void setPhoto(String photo) {
        if (photo != null && photo.trim().isEmpty()) photo = null;
        if (photo != null && photo.length() > 255)
            throw new IllegalArgumentException("Photo URL too long");
        if (photo != null && !photo.trim().matches("^(https?://|www\\.|[a-zA-Z0-9./\\-_]+\\.(jpg|jpeg|png|gif|bmp|webp)).*"))
            throw new IllegalArgumentException("Invalid photo format");
        this.photo = photo != null ? photo.trim() : null;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Product ID: " + getProductId());
        System.out.println("Category: " + getCategory());
        System.out.println("Photo URL: " + getPhoto());
    }

    @Override
    public void downloadOrShip() {
        if (getQuantity() <= 0) {
            System.out.println("Sorry, the product '" + getName() + "' is out of stock.");
        } else {
            System.out.println("Shipping Product: " + getName());
            System.out.println("Category: " + getCategory());
            System.out.println("Shipping photo: " + getPhoto());
            System.out.println("Product will be shipped in 2-3 business days.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", PhysicalProduct{ID=" + productId + ", category='" + category + "'}";
    }
}
