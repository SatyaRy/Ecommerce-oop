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

     private static Order[] orders = new Order[200];  // Adjust size
    private static int orderCount = 0;

    // Add new order
    public static void addOrder(Order order) {
        if (orderCount < orders.length) {
            orders[orderCount++] = order;
            System.out.println("Order added successfully!");
        } else {
            System.out.println("Order storage full!");
        }
    }

    // Find order by ID
    public static Order findOrderById(int orderId) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].order_id == orderId) {
                return orders[i];
            }
        }
        return null;
    }

    // Update order status (example)
    public static boolean updateOrderStatus(int orderId, String newStatus) {
        Order order = findOrderById(orderId);
        if (order != null) {
            order.order_status = newStatus;
            return true;
        }
        return false;
    }

    // Delete order by ID
    public static boolean deleteOrder(int orderId) {
        for (int i = 0; i < orderCount; i++) {
            if (orders[i].order_id == orderId) {
                orders[i] = orders[--orderCount];
                return true;
            }
        }
        return false;
    }

    // List all orders
    public static void listAllOrders() {
        if (orderCount == 0) {
            System.out.println("No orders available.");
            return;
        }
        for (int i = 0; i < orderCount; i++) {
            System.out.println("Order ID: " + orders[i].order_id + ", Status: " + orders[i].order_status + ", Date: " + orders[i].order_date + ", Total: $" + orders[i].total_amount);
        }
    }

}
