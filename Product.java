public class Product {
    int product_id;
    String product_name;
    String product_description;
    double product_price;
    String product_category;
    String product_photo;
    int product_quantity;

    public Product(
      int product_id, 
      String product_name, 
      String product_description,
      double product_price, 
      String product_category, 
      String product_photo,
      int product_quantity
      ){
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_category = product_category;
        this.product_photo = product_photo;
        this.product_quantity = product_quantity;
    }

    // Static array to store products
    private static Product[] products = new Product[100];
    private static int productCount = 0;

    // Method to add a new product
    public static void addProduct(Product product) {
        if (productCount < products.length) {
            products[productCount++] = product;
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Product storage is full!");
        }
    }

    // Method to view product details
    public void displayDetails() {
        System.out.println("\nProduct Details:");
        System.out.println("ID: " + product_id);
        System.out.println("Name: " + product_name);
        System.out.println("Description: " + product_description);
        System.out.println("Price: $" + product_price);
        System.out.println("Category: " + product_category);
        System.out.println("Quantity: " + product_quantity);
        System.out.println("Photo URL: " + product_photo);
    }

    // Method to update product information
    public void updateProduct(String name, String description, double price, 
                            String category, String photo, int quantity) {
        this.product_name = name;
        this.product_description = description;
        this.product_price = price;
        this.product_category = category;
        this.product_photo = photo;
        this.product_quantity = quantity;
        System.out.println("Product updated successfully!");
    }

    // Method to delete a product
    public static boolean deleteProduct(int productId) {
        for (int i = 0; i < productCount; i++) {
            if (products[i].product_id == productId) {
                products[i] = products[--productCount];
                return true;
            }
        }
        return false;
    }

    // Method to list all products
    public static void listAllProducts() {
        if (productCount == 0) {
            System.out.println("No products available.");
            return;
        }
        System.out.println("\nList of All Products:");
        for (int i = 0; i < productCount; i++) {
            products[i].displayDetails();
        }
    }

    // Main menu method for product management
    public static void productMenu() {
        java.util.Scanner scanner = null;
        try {
            scanner = new java.util.Scanner(System.in);
            while (true) {
                System.out.println("\n=== Product Management Menu ===");
                System.out.println("1. Add New Product");
                System.out.println("2. View Product Details");
                System.out.println("3. Update Product");
                System.out.println("4. Delete Product");
                System.out.println("5. List All Products");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("\nEnter Product Details:");
                        System.out.print("ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Price: ");
                        double price = scanner.nextDouble();
                        scanner.nextLine(); 
                        System.out.print("Category: ");
                        String category = scanner.nextLine();
                        System.out.print("Photo URL: ");
                        String photo = scanner.nextLine();
                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();
                        
                        Product newProduct = new Product(id, name, desc, price, category, photo, quantity);
                        addProduct(newProduct);
                        break;

                    case 2:
                        System.out.print("Enter Product ID: ");
                        int viewId = scanner.nextInt();
                        boolean found = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].product_id == viewId) {
                                products[i].displayDetails();
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Product not found!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Product ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); 
                        found = false;
                        for (int i = 0; i < productCount; i++) {
                            if (products[i].product_id == updateId) {
                                System.out.println("Enter new details (press Enter to keep current value):");
                                
                                System.out.print("Name [" + products[i].product_name + "]: ");
                                String newName = scanner.nextLine();
                                newName = newName.isEmpty() ? products[i].product_name : newName;

                                System.out.print("Description [" + products[i].product_description + "]: ");
                                String newDesc = scanner.nextLine();
                                newDesc = newDesc.isEmpty() ? products[i].product_description : newDesc;

                                System.out.print("Price [" + products[i].product_price + "]: ");
                                String priceStr = scanner.nextLine();
                                double newPrice = priceStr.isEmpty() ? products[i].product_price : Double.parseDouble(priceStr);

                                System.out.print("Category [" + products[i].product_category + "]: ");
                                String newCategory = scanner.nextLine();
                                newCategory = newCategory.isEmpty() ? products[i].product_category : newCategory;

                                System.out.print("Photo URL [" + products[i].product_photo + "]: ");
                                String newPhoto = scanner.nextLine();
                                newPhoto = newPhoto.isEmpty() ? products[i].product_photo : newPhoto;

                                System.out.print("Quantity [" + products[i].product_quantity + "]: ");
                                String quantityStr = scanner.nextLine();
                                int newQuantity = quantityStr.isEmpty() ? products[i].product_quantity : Integer.parseInt(quantityStr);

                                products[i].updateProduct(newName, newDesc, newPrice, newCategory, newPhoto, newQuantity);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            System.out.println("Product not found!");
                        }
                        break;

                    case 4:
                        System.out.print("Enter Product ID to delete: ");
                        int deleteId = scanner.nextInt();
                        if (deleteProduct(deleteId)) {
                            System.out.println("Product deleted successfully!");
                        } else {
                            System.out.println("Product not found!");
                        }
                        break;
                        
                    case 5:
                        listAllProducts();
                        break;
                    case 0:
                        System.out.println("Exiting Product Management...");
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
