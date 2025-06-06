public class Order {
    int order_id;
    String order_status;
    String order_date;
    double total_amount;

    public Order(
      int order_id,
    String order_status,
    String order_date,
    double total_amount
      ){
        this.order_id = order_id;
        this.order_status = order_status;
        this.order_date = order_date;
        this.total_amount = total_amount;
    }
}
