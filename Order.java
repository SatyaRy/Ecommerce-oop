public class Order {
    private int orderId;
    private int customerId;
    private int cardId;
    private String status;
    private String orderDate;
    private double totalAmount;

    public Order(int orderId, int customerId, int cardId, String status, String orderDate, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.cardId = cardId;
        this.status = status;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getOrderId() { return orderId; }
    public int getCustomerId() { return customerId; }
    public int getCardId() { return cardId; }
    public String getStatus() { return status; }
    public String getOrderDate() { return orderDate; }
    public double getTotalAmount() { return totalAmount; }

    public void displayOrder() {
        System.out.println("\n--- Order Summary ---");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer ID: " + customerId);
        System.out.println("Card ID: " + cardId);
        System.out.println("Status: " + status);
        System.out.println("Date: " + orderDate);
        System.out.println("Total: $" + totalAmount);
    }

    // total revenue
//     private static double totalRevenue = 0;

    // for constructor
//     totalRevenue += totalAmount;

    // for getter
//     public static double getTotalRevenue() {
//     return totalRevenue;
// }




}