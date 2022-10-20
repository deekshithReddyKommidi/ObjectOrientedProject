package Entity;


import lombok.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@RequiredArgsConstructor
public class AirPlane {
    @Getter
    private final String uid = UUID.randomUUID().toString();
    @Getter @Setter
    @NonNull
    private String customerId;
    @Getter @Setter
    @NonNull
    private Maker maker;
    @Getter @Setter
    @NonNull
    private Wings wings;
    @Getter @Setter
    @NonNull
    private FuelType fuelType;
    @Getter @Setter
    @NonNull
    private Model model;
    @Getter @Setter
    @NonNull
    private double price;
    @Getter
    private final Timestamp createdAt = Timestamp.from(Instant.now());


    public AirPlane(){

    }
}
