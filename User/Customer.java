package User;

import java.sql.Date;

public class Customer extends User {
    private int customerId;

    protected Customer(int customerId, String name, String email, String password,
                    String phoneNumber, Date registeredDate, String address) {
        super(name, email, password, phoneNumber, registeredDate, address);
        if (customerId <= 0) {
            throw new IllegalArgumentException("Customer ID must be positive");
        }
        this.customerId = customerId;
    }

    protected int getCustomerId() {
        return customerId;
    }

    protected void updateContactInfo(String newPhone, String newAddress) {
        setPhoneNumber(newPhone);     
        setAddress(newAddress);      
    }


    protected void showEmail() {
        System.out.println("Customer Email: " + getEmail()); 
    }

    // customer use abstract method to display basic info from User class
    @Override
    protected void displayBasicInfo() {
        System.out.println("\n--- Customer Info ---");
        System.out.println("Customer ID: " + customerId);
        printCommonInfo();
    }
}
