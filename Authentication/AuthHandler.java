package Authentication;

import User.User;
import User.Customer;
import User.Seller;

// File: AuthHandler.java

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * This class handles the logic for the authentication form.
 * It implements ActionListener to respond to button clicks.
 */
public class AuthHandler implements ActionListener {

    // A reference to the AuthForm to access its fields
    private final AuthForm authForm;

    public AuthHandler(AuthForm authForm) {
        this.authForm = authForm;
    }

    /**
     * This method is called when an action (like a button click) occurs.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // --- 1. Retrieve Data from Form Fields ---
        String name = authForm.getNameField().getText();
        String email = authForm.getEmailField().getText();
        
        // getPassword() returns a char array for security, so we convert it to a String
        String password = new String(authForm.getPasswordField().getPassword());
        
        String phone = authForm.getPhoneField().getText();
        String address = authForm.getAddressArea().getText();
        String role = (String) authForm.getRoleComboBox().getSelectedItem();

        // --- 2. Basic Input Validation ---
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(authForm, 
                "Name, Email, and Password fields cannot be empty.", 
                "Input Error", 
                JOptionPane.ERROR_MESSAGE);
            return; // Stop further processing
        }

        // --- 3. Create a User Object ---
        // We package the collected data into our User model object.
        User newUser;
        if (role.equalsIgnoreCase("customer")) {
            // Use dummy customerId and current date
            int customerId = (int)(System.currentTimeMillis() % 100000); // simple unique id
            java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());
            newUser = new Customer(customerId, name, email, password, phone, registeredDate, address);
        } else if (role.equalsIgnoreCase("seller")) {
            // Use dummy sellerId, current date, and default photo
            int sellerId = (int)(System.currentTimeMillis() % 100000);
            java.sql.Date registeredDate = new java.sql.Date(System.currentTimeMillis());
            String photo = "default.jpg";
            newUser = new Seller(sellerId, name, email, password, phone, registeredDate, address, photo);
        } else {
            throw new IllegalArgumentException("Invalid role: " + role);
        }

        // --- 4. "Authentication" Logic ---
        // For this example, we'll just print the user details to the console
        // and show a success message. In a real application, this is where you
        // would save the user to a database.
        System.out.println("--- New User Registration ---");
        System.out.println(newUser.toString());

        // Securely clear the password field after use
        authForm.getPasswordField().setText("");
        Arrays.fill(password.toCharArray(), ' '); // Overwrite password in memory
        
        // --- 5. Show Success Message ---
        JOptionPane.showMessageDialog(authForm, 
            "Registration Successful for " + newUser.getName() + "!", 
            "Success", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}