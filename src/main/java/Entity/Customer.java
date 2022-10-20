package Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
public class Customer {

    @Getter
    private final String uid = UUID.randomUUID().toString();
    @Getter @Setter
    @NonNull
    private String name;
    @Getter @Setter
    @NonNull
    private String address;


}