package Authentication;

// File: AuthForm.java

import javax.swing.*;
import java.awt.*;

/**
 * This class is responsible for creating and displaying the GUI form.
 * It separates the visual design from the application logic.
 */
public class AuthForm extends JFrame {

    // --- GUI Components ---
    // We declare components here to access them throughout the class.
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JTextField phoneField;
    private JTextArea addressArea;
    private JComboBox<String> roleComboBox;
    private JButton registerButton;

    // --- Constructor ---
    public AuthForm() {
        // --- Basic Window Setup ---
        setTitle("User Authentication Form");
        // Set the action for the close button (exit the application)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Set a fixed size for the window
        setSize(400, 450);
        // Center the window on the screen
        setLocationRelativeTo(null);
        
        // --- Main Panel Setup ---
        // Create a main panel to hold all components, using BorderLayout.
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10)); // 10px horizontal/vertical gaps
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // 10px margin
        
        // --- Form Panel for Input Fields ---
        // Create a panel for the form fields using GridLayout.
        // 6 rows, 2 columns, with 5px horizontal and vertical gaps.
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 5, 5));
        
        // --- Initialize and Add Components to the Form Panel ---
        
        // 1. Name
        formPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        formPanel.add(nameField);

        // 2. Email
        formPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        formPanel.add(emailField);

        // 3. Password
        formPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        formPanel.add(passwordField);

        // 4. Phone Number
        formPanel.add(new JLabel("Phone Number:"));
        phoneField = new JTextField();
        formPanel.add(phoneField);

        // 5. Address
        formPanel.add(new JLabel("Address:"));
        addressArea = new JTextArea(3, 20); // 3 rows, 20 columns
        addressArea.setLineWrap(true); // Enable line wrapping
        addressArea.setWrapStyleWord(true); // Wrap at word boundaries
        JScrollPane addressScrollPane = new JScrollPane(addressArea); // Add a scroll bar
        formPanel.add(addressScrollPane);
        
        // 6. Role
        formPanel.add(new JLabel("Role:"));
        String[] roles = {"Customer", "Seller"};
        roleComboBox = new JComboBox<>(roles);
        formPanel.add(roleComboBox);

        // --- Button Panel ---
        JPanel buttonPanel = new JPanel(); // Default FlowLayout is fine here
        registerButton = new JButton("Register");
        buttonPanel.add(registerButton);

        // --- Add Form and Button Panels to Main Panel ---
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // --- Finalize Window ---
        // Add the main panel to the JFrame's content pane
        add(mainPanel);

        // --- Event Handling ---
        // Create an instance of our event handler and attach it to the button.
        // We pass `this` (the AuthForm instance) to the handler so it can access the form's fields.
        AuthHandler handler = new AuthHandler(this);
        registerButton.addActionListener(handler);
    }
    
    // --- Getters for Form Fields ---
    // These methods allow the AuthHandler to get the data from the private fields.
    public JTextField getNameField() { return nameField; }
    public JTextField getEmailField() { return emailField; }
    public JPasswordField getPasswordField() { return passwordField; }
    public JTextField getPhoneField() { return phoneField; }
    public JTextArea getAddressArea() { return addressArea; }
    public JComboBox<String> getRoleComboBox() { return roleComboBox; }
}