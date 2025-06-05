public class Coupoun{
    String productId;     
    String productName;  
    int quantity;        
    double price;         
    double totalPrice; 

    // Constructors
    public Coupoun() {}

    public Coupoun(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = quantity * price;
    }

    // Getters and Setters

 
}
