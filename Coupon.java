public class Coupon{
    String couponID;     
    int coupon_code;  
    String created_date;
    String expired_date;
    double discount_percentage;
    // Constructors
    public Coupon() {}

    public Coupon(String couponID, int coupon_code,String created_date, String expired_date,double discount_percentage) {
        this.couponID = couponID;
        this.coupon_code = coupon_code;
        this.created_date = created_date;
        this.expired_date = expired_date;
        this.discount_percentage = discount_percentage;
    }

    // Getters and Setters

 
}
