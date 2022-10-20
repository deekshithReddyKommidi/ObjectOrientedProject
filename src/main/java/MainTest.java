import Entity.Customer;
import Entity.Maker;
import Factory.Person;
import Factory.PersonFactory;
import Iterator.Coupon;
import Iterator.CouponRepository;
import Iterator.Iterator;
import Observer.DeliveryPackage;
import Observer.NotificationService;
import Observer.PackageStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

public class MainTest {

    private Customer customer = new Customer("Test","Test Address");
    private Person male = PersonFactory.getMaker(customer, Maker.AIRBUS);
    @Test
    public void TestThis(){

        System.out.println(male.getUserDetailsAndDesc());
        DeliveryPackage deliveryPackage = new DeliveryPackage(UUID.randomUUID().toString(),
                male.getMaker(), PackageStatus.STARTED.name());
        /** created diffrent instance to check the test case passes or not **/
        new NotificationService().subscribe(customer,deliveryPackage);
        new NotificationService().notifyCustomer(deliveryPackage);
        new NotificationService().unSubscribe(customer,deliveryPackage);

        /** used the object of same instance as another test case **/

    }

    @Test
    public void multipleInstances(){
        DeliveryPackage deliveryPackage = new DeliveryPackage(UUID.randomUUID().toString(),
                male.getMaker(), PackageStatus.STARTED.name());
        /** created diffrent instance to check the test case passes or not **/
        new NotificationService().subscribe(customer,deliveryPackage);
        new NotificationService().notifyCustomer(deliveryPackage);
        new NotificationService().unSubscribe(customer,deliveryPackage);

        System.out.println("Instance one "+new NotificationService().hashCode());
        System.out.println("Instance two "+new NotificationService().hashCode());
    }

    @Test
    public void singleInstance(){
        DeliveryPackage deliveryPackage = new DeliveryPackage(UUID.randomUUID().toString(),
                male.getMaker(), PackageStatus.STARTED.name());
        NotificationService notificationService= new NotificationService();
        notificationService.subscribe(customer,deliveryPackage);
        System.out.println("Instance before "+notificationService.hashCode());
        notificationService.notifyCustomer(deliveryPackage);
        notificationService.unSubscribe(customer,deliveryPackage);
        System.out.println("Instance after "+notificationService.hashCode());
    }

    @Test
    public void testTheIterator(){
        CouponRepository couponRepository = new CouponRepository();
        for (Iterator iter = couponRepository.getIterator(); iter.hasNext(); ) {
            Coupon model = (Coupon) iter.next();
            /** positives must here **/
            Assert.assertEquals("FLYHIGH",model.getCouponCode());
            Assert.assertEquals((double) 2500.00,(double)model.getDiscountMaxPrice());
            Assert.assertEquals((int)15,(int)model.getDiscountPercent());

            /** tested negative result  **/
            Assert.assertEquals("Test",model.getCouponCode());
            Assert.assertEquals((double) 00.00,(double)model.getDiscountMaxPrice());
            Assert.assertEquals((int)0,(int)model.getDiscountPercent());
        }
    }
}
