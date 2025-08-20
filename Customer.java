public class Customer {
    int customer_id;
    String customer_name;
    String customer_email;
    String customer_password;
    String customer_address;
    String registered_date;
    String customer_phone_number;

    public Customer(
      int customer_id, 
      String customer_name, 
      String customer_email, 
      String customer_password,
      String customer_address, 
      String registered_date, 
      String customer_phone_number
      ){
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_password = customer_password;
        this.customer_address = customer_address;
        this.registered_date = registered_date;
        this.customer_phone_number = customer_phone_number;
    }

    private static Customer[] customers = new Customer[200];  
    private static int customerCount = 0;

    // Add new customers 
    public static void addCustomer(Customer customer) {
        if (customerCount < customers.length) {
            customers[customerCount++] = customer;
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Customer storage full!");
        }
    }


    // Find the customers by ID
    public static Customer findCustomerById(int customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].customer_id == customerId) {
                return customers[i];
            }
        }
        return null;
    }

    // Delete customer by ID
    public static boolean deleteCustomer(int customerId) {
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].customer_id == customerId) {
                customers[i] = customers[--customerCount];
                return true;
            }
        }
        return false;
    }

    //Update customer information
    public void updateCustomerInfo(int customer_id, String customer_name,
      String customer_email, String customer_password,
      String customer_address, String registered_date,
      String customer_phone_number) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_email = customer_email;
        this.customer_password = customer_password;
        this.customer_address = customer_address;
        this.registered_date = registered_date;
        this.customer_phone_number = customer_phone_number;
        System.out.println("Customer information updated successfully!");
    }

    //List all customers
    public static void listAllCustomers() {
        System.out.println("List of all customers:");
        for (int i = 0; i < customerCount; i++) {
            Customer customer = customers[i];
            System.out.println("Customer ID: " + customer.customer_id);
            System.out.println("Customer Name: " + customer.customer_name);
            System.out.println("Customer Email: " + customer.customer_email);
            System.out.println("Customer Address: " + customer.customer_address);
            System.out.println("Registered Date: " + customer.registered_date);
            System.out.println("Customer Phone Number: " + customer.customer_phone_number);
        }
    }
}
