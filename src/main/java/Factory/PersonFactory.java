package Factory;

import Entity.Customer;
import Entity.Maker;

public class PersonFactory {

      public static Person getMaker(Customer customer, Maker maker) {
          if(Maker.BOEING.name().equals(maker.name())) {
              return new Boeing(customer);
          } else if(Maker.AIRBUS.name().equals(maker.name())) {
              return new AirBus(customer);
          } else if (Maker.BOMBARDIER.name().equals(maker.name())){
              return new Bombardier(customer);
          }
          return null;
      }
}