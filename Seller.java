public class Seller {
    int seller_id;
    String seller_name;
    String seller_email;
    String seller_password;
    String seller_phone_number;
    String seller_address;
    String seller_photo;

    public Seller(
        int seller_id, 
        String seller_name, 
        String seller_email, 
        String seller_password,
        String seller_phone_number, 
        String seller_address, 
        String seller_photo
        ){
        this.seller_id = seller_id;
        this.seller_name = seller_name;
        this.seller_email = seller_email;
        this.seller_password = seller_password;
        this.seller_phone_number = seller_phone_number;
        this.seller_address = seller_address;
        this.seller_photo = seller_photo;
    }
}