public class Seller {
    private int sellerId;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String photo;

    public Seller(int sellerId, String name, String email, String password,
                  String phoneNumber, String address, String photo) {
        this.sellerId = sellerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.photo = photo;
    }

    // Getters
    public int getSellerId() { return sellerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getAddress() { return address; }
    public String getPhoto() { return photo; }

    // Optional display
    public void displaySellerInfo() {
        System.out.println("\n--- Seller Info ---");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
