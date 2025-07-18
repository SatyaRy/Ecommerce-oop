package User;

import java.sql.Date;

public class Customer extends User{
    private int customerId;

    public Customer(int customerId, String name, String email, String password,
                    String phoneNumber, Date registeredDate, String address) {
        super(name, email, password, phoneNumber, registeredDate, address);
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void displayCustomerInfo() {
        System.out.println("\n--- Customer Info ---");
        System.out.println("Customer ID: " + customerId);
        displayBasicInfo(); // Reuse method from User class
    }

}