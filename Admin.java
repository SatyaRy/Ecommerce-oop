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
    
    private static Admin adminInstance = null;  

    public static Admin createInstance(int admin_id, String admin_name,
      String admin_email,
      String admin_password,
      String admin_phone_number){
        if(adminInstance == null){
          adminInstance = new Admin(
            admin_id, 
            admin_name, 
            admin_email, 
            admin_password, 
            admin_phone_number
          );
        }else {
          System.out.println("Admin instance already exists.");
        }
        return adminInstance;
    }

    public static Admin getInstance() {
        return adminInstance;
    }

    public void displayAdminInfo() {
      System.out.println("\nAdmin Information:");
        System.out.println("Admin ID: " + admin_id);
        System.out.println("Admin Name: " + admin_name);
        System.out.println("Admin Email: " + admin_email);
        System.out.println("Admin Phone Number: " + admin_phone_number);
    }

    public void updateAdminInfo(int admin_id, String admin_name,
      String admin_email,
      String admin_password,
      String admin_phone_number){
        this.admin_id = admin_id;
        this.admin_name = admin_name;
        this.admin_email = admin_email;
        this.admin_password = admin_password;
        this.admin_phone_number = admin_phone_number;
        System.out.println("Admin information updated successfully!");
      }
}