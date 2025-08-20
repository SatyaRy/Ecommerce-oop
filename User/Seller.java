package User;

import java.sql.Date;

public class Seller extends User {
    private int sellerId;
    private String photo;

    protected Seller(int sellerId, String name, String email, String password,
                  String phoneNumber, Date registeredDate, String address, String photo) {
        super(name, email, password, phoneNumber, registeredDate, address);
        if (sellerId <= 0) {
            throw new IllegalArgumentException("Seller ID must be positive");
        }
        this.sellerId = sellerId;
        this.photo = photo;
    }

    protected int getSellerId() {
        return sellerId;
    }

    protected String getPhoto() {
        return photo;
    }

    protected void updateProfile(String newName, String newEmail) {
        setName(newName);     
        setEmail(newEmail);   
    }

    protected void printSellerName() {
        System.out.println("Seller Name: " + getName()); 
    }

    // seller use abstract method to display basic info from User class
    @Override
    protected void displayBasicInfo() {
        System.out.println("\n--- Seller Info ---");
        System.out.println("Seller ID: " + sellerId);
        System.out.println("Photo: " + photo);
        printCommonInfo();
    }
}
