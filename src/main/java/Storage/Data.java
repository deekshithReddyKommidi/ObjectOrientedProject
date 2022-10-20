package Storage;

import Iterator.Coupon;
import java.util.ArrayList;
import java.util.List;

public class Data {
    public static List<Coupon> getCoupons(){
        List<Coupon> coupons = new ArrayList<>();
        coupons.add(new Coupon(2500.00,15,"FIRSTFLY"));
        coupons.add(new Coupon(2500.00,15,"DREAMBIG"));
        coupons.add(new Coupon(2500.00,15,"DEEKSHITH"));
        return coupons;
    }
}
