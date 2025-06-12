public class Product {
    int product_id;
    String product_name;
    String product_description;
    double product_price;
    String product_category;
    String product_photo;
    int product_quantity;

    public Product(int product_id, String product_name, String product_description,
                   double product_price, String product_category, String product_photo,
                   int product_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_description = product_description;
        this.product_price = product_price;
        this.product_category = product_category;
        this.product_photo = product_photo;
        this.product_quantity = product_quantity;
    }

    public void displayDetails() {
        System.out.println("\n--- Product Details ---");
        System.out.println("ID: " + product_id);
        System.out.println("Name: " + product_name);
        System.out.println("Description: " + product_description);
        System.out.println("Price: $" + product_price);
        System.out.println("Category: " + product_category);
        System.out.println("Photo: " + product_photo);
        System.out.println("Quantity: " + product_quantity);
    }

    static Product[] products = new Product[100];
    static int productCount = 0;

    public static void productMenu() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Product Management Menu ===");
            System.out.println("1. Add New Product");
            System.out.println("2. View Product Details");
            System.out.println("3. List All Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;

                case 2:
                    viewProduct(scanner);
                    break;

                case 3:
                    listAllProducts();
                    break;

                case 0:
                    System.out.println("Exiting Product Management...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    public static void addProduct(java.util.Scanner scanner) {
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
        products[productCount] = newProduct;
        productCount++;

        System.out.println("Product added successfully!");
    }

    public static void viewProduct(java.util.Scanner scanner) {
        System.out.print("Enter Product ID to view: ");
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
    }

    public static void listAllProducts() {
        if (productCount == 0) {
            System.out.println("No products available.");
        } else {
            for (int i = 0; i < productCount; i++) {
                products[i].displayDetails();
            }
        }
    }

    public static void main(String[] args) {
        productMenu();
    }
}
