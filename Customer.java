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
}
