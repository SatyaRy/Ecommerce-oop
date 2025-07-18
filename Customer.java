package Authentication;


public class Customer {
    private int customerId;
    private String name;
    private String email;
    private String password;
    private String address;
    private String registeredDate;
    private String phoneNumber;

    public Customer(int customerId, String name, String email, String password,
                    String address, String registeredDate, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.registeredDate = registeredDate;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getAddress() { return address; }
    public String getRegisteredDate() { return registeredDate; }
    public String getPhoneNumber() { return phoneNumber; }

    // Display customer summary
    public void displayCustomerInfo() {
        System.out.println("\n--- Customer Info ---");
        System.out.println("ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Registered: " + registeredDate);
    }
}
