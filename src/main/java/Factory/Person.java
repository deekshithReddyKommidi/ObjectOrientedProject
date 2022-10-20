package Factory;

import Entity.Customer;

public abstract class Person {

     Person(Customer customer) {
         this.customer = customer;
     }

     private Customer customer;

     public abstract String getMaker();

     public String getUserDetailsAndDesc() {

         return getMaker()+"\n your order will be deliver to "+customer.getAddress();
     }

}