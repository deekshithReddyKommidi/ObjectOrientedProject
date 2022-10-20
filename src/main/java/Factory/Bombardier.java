package Factory;

import Entity.Customer;

class Bombardier extends Person {

    public Bombardier(Customer customer) {
        super(customer);
    }

    @Override
    public String getMaker() {
          return "You have selected Bombardier Inc as your maker. is a Canadian business jet manufacturer. It was also formerly a manufacturer of commercial jets, public transport vehicles, trains, and recreational vehicles, with the last being spun-off as Bombardier Recreational Products. ";
    }
}