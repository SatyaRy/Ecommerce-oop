// DigitalProduct Sub Class:
package Product;

public class DigitalProduct extends Product {
    private int productId;
    private String photo;

    public DigitalProduct(int productId, String name, String description,
                          double price, String photo, int quantity, int sellerId) {
        super(name, description, price, quantity, sellerId);
        setProductId(productId);
        setPhoto(photo);
    }

    public int getProductId() {
        if (productId <= 0) throw new IllegalStateException("Invalid product ID");
        return productId;
    }

    public String getPhoto() {
        return photo != null ? photo : "No photo available";
    }

    public void setProductId(int productId) {
        if (productId <= 0 || productId > 999999)
            throw new IllegalArgumentException("Product ID must be between 1 and 999,999");
        this.productId = productId;
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
        System.out.println("Category: Digital");
        System.out.println("Photo URL: " + getPhoto());
    }

    @Override
    public void downloadOrShip() {
        if (getQuantity() <= 0) {
            System.out.println("Sorry, the digital product '" + getName() + "' is unavailable.");
        } else {
            System.out.println("Preparing digital delivery for: " + getName());
            System.out.println("Download Link: " + generateDownloadLink());
            System.out.println("License Key: " + generateLicenseKey());
        }
    }

    
    private String generateDownloadLink() {
        return "https://download.myeshop.com/" + getProductId();
    }
    
    private String generateLicenseKey() {
        return "KEY-" + getProductId() + "-" + (int)(Math.random() * 100000);
    }
    
    @Override
    public String toString() {
        return super.toString() + ", DigitalProduct{ID=" + productId + ", category='Digital'}";
    }
    
    //static for subclass DigitalProduct
    public static void showDigitalDownloadPolicy() {
    System.out.println("Digital products can be downloaded instantly after purchase.");

    //can implement below:
    //DigitalProduct.showDigitalDownloadPolicy();
}

    //create euqal method for the superclass and reuse it in the subclass
    @Override
public boolean equals(Object obj) {
    // First, check with parent equals()
    if (!super.equals(obj)) return false;

    // Then check if the object is a DigitalProduct
    if (!(obj instanceof DigitalProduct)) return false;

    DigitalProduct other = (DigitalProduct) obj;
    return this.getProductId() == other.getProductId(); // add your own subclass logic
}
}