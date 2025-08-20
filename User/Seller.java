package User;

import java.sql.Date;

public class Seller extends User {
    private int sellerId;
    private String photo;

    public Seller(int sellerId, String name, String email, String password,
                  String phoneNumber, Date registeredDate, String address, String photo) {
        super(name, email, password, phoneNumber, registeredDate, address);
        if (sellerId <= 0) {
            throw new IllegalArgumentException("Seller ID must be positive");
        }
        this.sellerId = sellerId;
        this.photo = photo;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getPhoto() {
        return photo;
    }

    public void updateProfile(String newName, String newEmail) {
        setName(newName);     
        setEmail(newEmail);   
    }

    public void printSellerName() {
        System.out.println("Seller Name: " + getName()); 
    }

    public void displayBasicInfo() {
        System.out.println("\n--- Seller Info ---");
        System.out.println("Seller ID: " + sellerId);
        System.out.println("Photo: " + photo);
        super.displayBasicInfo();
    }
}
