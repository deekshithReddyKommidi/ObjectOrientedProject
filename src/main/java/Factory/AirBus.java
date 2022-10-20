package Factory;

import Entity.Customer;

class AirBus extends Person {

    public AirBus(Customer customer) {
        super(customer);
    }

    @Override
    public String getMaker() {
        return "You have choose AirBus for manufacturing your Aeroplane\n Airbus SE is a European multinational aerospace corporation. Airbus designs, manufactures and sells civil and military aerospace products worldwide and manufactures aircraft in Europe and various countries outside Europe";
    }
}