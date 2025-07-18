package User;

import java.sql.Date;

public class Customer extends User {
    private int customerId;

    public Customer(int customerId, String name, String email, String password,
                    String phoneNumber, Date registeredDate, String address) {
        super(name, email, password, phoneNumber, registeredDate, address);
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive");
        }
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void updateContactInfo(String newPhone, String newAddress) {
        setPhoneNumber(newPhone);     
        setAddress(newAddress);      
    }


    public void showEmail() {
        System.out.println("Customer Email: " + getEmail()); 
    }

    @Override
    public void displayBasicInfo() {
        System.out.println("\n--- Customer Info ---");
        System.out.println("Customer ID: " + customerId);
        super.displayBasicInfo();
    }
}
