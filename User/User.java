package User;

import java.sql.Date;

public class User {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Date registeredDate;
    private String address;
    public User(String name, String email, String password,
                String phoneNumber, Date registeredDate,String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.registeredDate = registeredDate;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    // Getters for common attributes

    protected String getName() {
        return name;
    }
    protected String getEmail() {
        return email;
    }
    protected String getPassword() {
        return password;
    }
    protected String getPhoneNumber() {
        return phoneNumber;
    }
    protected String getAddress() {
        return address;
    }
    protected Date getRegisteredDate() {
        return registeredDate;
    }


    // Setters for common attributes (if needed)
    protected void setName(String name) {
        this.name = name;
    }

    protected void setEmail(String email) {
        this.email = email;
    }
    protected void setPassword(String password) {
        this.password = password;
    }
    protected void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    protected void setAddress(String address) {
        this.address = address;
    }
    protected void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Registered Date: " + registeredDate);
    }

}
