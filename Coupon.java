import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

     public boolean isValid() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(this.expired_date, formatter);
        return !today.isAfter(expiry);
    }
    public double applyDiscount(double totalAmount) {
        if (isValid()) {
            return totalAmount - (totalAmount * (discount_percentage / 100));
        } else {
            System.out.println("Coupon expired.");
            return totalAmount;
        }
    }
 
}
