package Factory;

import Entity.Customer;

class Boeing extends Person {

    public Boeing(Customer customer) {
        super(customer);
    }

    @Override
    public String getMaker() {
          return "You selected Boeing as the maker\n The Boeing Company is an American multinational corporation that designs, manufactures, and sells airplanes, rotorcraft, rockets, satellites, telecommunications equipment, and missiles worldwide. The company also provides leasing and product support services.";
    }
}