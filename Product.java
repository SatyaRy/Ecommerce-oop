package ecommerce;

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
}
