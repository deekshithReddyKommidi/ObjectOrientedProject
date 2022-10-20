package Iterator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Coupon {
    @Getter @Setter
    private Double discountMaxPrice;
    @Getter @Setter
    private Integer discountPercent;
    @Getter @Setter
    private String couponCode;

}
