package Observer;

import Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class DeliveryPackage {

    @NonNull
    @Getter @Setter
    private String uid;
    @NonNull
    @Getter @Setter
    private String type;
    @NonNull
    @Getter @Setter
    private String status;

    @Getter @Setter
    private List<Customer> customers;

    public DeliveryPackage(@NonNull String uid, @NonNull String type, @NonNull String status) {
        this.uid = uid;
        this.type = type;
        this.status = status;
    }
}