package User;

import java.sql.Date;

public class Seller extends User {
    private int sellerId;

    public Seller(int sellerId, String name, String email, String password,
                  String phoneNumber, Date registeredDate, String address, String photo) {
        super(name, email, password, phoneNumber, registeredDate, address);

        this.sellerId = sellerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void displaySellerInfo() {
        System.out.println("\n--- Seller Info ---");
        System.out.println("Seller ID: " + sellerId);
        displayBasicInfo(); // Reuse method from User class
    }
}
