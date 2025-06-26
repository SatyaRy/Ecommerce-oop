public class Order {
    private int orderId;
    private String status;
    private String date;
    private double totalAmount;

    public Order(int orderId, String status, String date, double totalAmount) {
        this.orderId = orderId;
        this.status = status;
        this.date = date;
        this.totalAmount = totalAmount;
    }

    // Getters
    public int getOrderId() { return orderId; }
    public String getStatus() { return status; }
    public String getDate() { return date; }
    public double getTotalAmount() { return totalAmount; }

    public void displayOrder() {
        System.out.println("\n--- Order Summary ---");
        System.out.println("Order ID: " + orderId);
        System.out.println("Status: " + status);
        System.out.println("Date: " + date);
        System.out.println("Total: $" + totalAmount);
    }
}
