import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Coupon {
    private String couponId;
    private int code;
    private String createdDate;
    private String expiredDate;
    private double discountPercentage;

    public Coupon() {}

    public Coupon(String couponId, int code, String createdDate, String expiredDate, double discountPercentage) {
        this.couponId = couponId;
        this.code = code;
        this.createdDate = createdDate;
        this.expiredDate = expiredDate;
        this.discountPercentage = discountPercentage;
    }

    // Getters
    public String getCouponId() { return couponId; }
    public int getCode() { return code; }
    public String getCreatedDate() { return createdDate; }
    public String getExpiredDate() { return expiredDate; }
    public double getDiscountPercentage() { return discountPercentage; }

    public boolean isValid() {
        LocalDate today = LocalDate.now();
        LocalDate expiry = LocalDate.parse(this.expiredDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return !today.isAfter(expiry);
    }

    public double applyDiscount(double total) {
        if (isValid()) {
            return total - (total * (discountPercentage / 100));
        } else {
            System.out.println("⚠️ Coupon expired.");
            return total;
        }
    }

    public void showCoupon() {
        System.out.println("Coupon ID: " + couponId + " | Discount: " + discountPercentage + "% | Expires: " + expiredDate);
    }
}
