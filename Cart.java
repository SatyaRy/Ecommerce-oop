public class Cart {
    int cart_id;
    int customer_id;
    int product_id;
    int seller_id;

    public Cart(int cart_id, int customer_id, int product_id, int seller_id) {
        this.cart_id = cart_id;
        this.customer_id = customer_id;
        this.product_id = product_id;
        this.seller_id = seller_id;
    }
}