public class Admin {
    int admin_id;
    String admin_name;
    String admin_email;
    String admin_password;
    String admin_phone_number;

    public Admin(
      int admin_id,
    String admin_name,
    String admin_email,
    String admin_password,
    String admin_phone_number
      ){
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_email = admin_email;
        this.admin_password = admin_password;
        this.admin_phone_number = admin_phone_number; 
    }
}