package User;

import java.util.Date;

public class User {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Date registeredDate;

    protected User(String name, String email, String password,
                String phoneNumber, Date registeredDate, String address) {
        setName(name);
        setEmail(email);
        setPassword(password);
        setPhoneNumber(phoneNumber);
        setRegisteredDate(registeredDate);
        setAddress(address);
    }

    // Getters
    public String getName() {
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

    // Setters with validation
    protected void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
        this.name = name.trim();
    }

    protected void setEmail(String email) {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email.trim();
    }

    protected void setPassword(String password) {
        if (password == null || password.length() < 8 || !password.matches(".*\\d.*") || !password.matches(".*[A-Za-z].*")) {
            throw new IllegalArgumentException("Password must be at least 8 characters long and contain both letters and numbers");
        }
        this.password = password;
    }

    protected void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("^[0-9]{10,15}$")) {
            throw new IllegalArgumentException("Phone number must contain only digits and be 10 to 15 digits long");
        }
        this.phoneNumber = phoneNumber;
    }

    protected void setAddress(String address) {
        if (address == null || address.trim().isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or blank");
        }
        this.address = address.trim();
    }

    protected void setRegisteredDate(Date registeredDate) {
        if (registeredDate == null) {
            throw new IllegalArgumentException("Registered date cannot be null");
        }
        if (registeredDate.after(new Date())) {
            throw new IllegalArgumentException("Registered date cannot be in the future");
        }
        this.registeredDate = registeredDate;
    }

    protected void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("Registered Date: " + registeredDate);
    }
}
