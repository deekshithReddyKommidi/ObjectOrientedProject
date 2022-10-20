import Entity.*;
import Factory.Person;
import Factory.PersonFactory;
import Iterator.Coupon;
import Iterator.CouponRepository;
import Iterator.Iterator;
import Observer.DeliveryPackage;
import Observer.NotificationService;
import Observer.PackageStatus;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Deekshith","Chicago University Park");

        System.out.println("Welcome "+customer.getName());


        AirPlane airPlane = new AirPlane();
        airPlane.setCustomerId(customer.getUid());

        System.out.println(Arrays.toString(Maker.values())+" choose the maker");
        String makerIp = new Scanner(System.in).next();
        if (Maker.BOMBARDIER.name().equals(makerIp))
            airPlane.setMaker(Maker.BOMBARDIER);
        else if (Maker.BOEING.name().equals(makerIp))
            airPlane.setMaker(Maker.BOEING);
        else if (Maker.AIRBUS.name().equals(makerIp))
            airPlane.setMaker(Maker.AIRBUS);


        System.out.println(Arrays.toString(FuelType.values())+" choose the fuel type");
        String fuelTypeIp = new Scanner(System.in).next();
        if (FuelType.AVGAS_100_130.name().equals(fuelTypeIp))
            airPlane.setFuelType(FuelType.AVGAS_100_130);
        else if (FuelType.AVGAS_100LL.name().equals(fuelTypeIp))
            airPlane.setFuelType(FuelType.AVGAS_100LL);
        else if (FuelType.UL_91.name().equals(fuelTypeIp))
            airPlane.setFuelType(FuelType.UL_91);

        System.out.println(Arrays.toString(Model.values())+" choose the Model");
        String modelIp = new Scanner(System.in).next();
        if (Model.A300.name().equals(modelIp)){
            airPlane.setModel(Model.A300);
            airPlane.setPrice(178925.00);
        } else if (Model.B737.name().equals(modelIp)){
            airPlane.setModel(Model.B737);
            airPlane.setPrice(134587.00);
        }else if (Model.CHALLENGER650.name().equals(modelIp)){
            airPlane.setModel(Model.CHALLENGER650);
            airPlane.setPrice(156258.00);
        }



        Person male = PersonFactory.getMaker(customer, Maker.AIRBUS);
        System.out.println(male.getUserDetailsAndDesc());

        System.out.println("Enter Coupon Code");

        String coupon = new Scanner(System.in).next();
        CouponRepository couponRepository = new CouponRepository();

        if (coupon.length()>0) {
            for (Iterator iter = couponRepository.getIterator(); iter.hasNext(); ) {
                Coupon model = (Coupon) iter.next();
                if (model.getCouponCode().equalsIgnoreCase(coupon)){
                    System.out.println("Congrats " + model.getDiscountPercent()+" % is on us");
                    double mod = ((model.getDiscountMaxPrice()- airPlane.getPrice())/ model.getDiscountMaxPrice())*model.getDiscountPercent();
                    airPlane.setPrice(mod);
                    System.out.println("Final Price is " +mod+" ");
                }

            }
        }
        DeliveryPackage deliveryPackage = new DeliveryPackage(UUID.randomUUID().toString(),
                male.getMaker(),PackageStatus.STARTED.name());

        NotificationService notificationService= new NotificationService();

        notificationService.subscribe(customer,deliveryPackage);

        deliveryPackage.setStatus(PackageStatus.STARTED.name());

        notificationService.notifyCustomer(deliveryPackage);

        deliveryPackage.setStatus(PackageStatus.OUT_FOR_DELIVERY.name());

        notificationService.notifyCustomer(deliveryPackage);

        deliveryPackage.setStatus(PackageStatus.DELIVERED.name());

        notificationService.notifyCustomer(deliveryPackage);

        notificationService.unSubscribe(customer,deliveryPackage);

        notificationService.notifyCustomer(deliveryPackage);
    }
}
