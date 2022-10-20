package Iterator;

import Storage.Data;

import java.util.List;

public class CouponRepository implements Container {
   public List<Coupon> coupons = Data.getCoupons();

   @Override
   public Iterator getIterator() {
      return new NameIterator();
   }

   private class NameIterator implements Iterator {

      int index;

      @Override
      public boolean hasNext() {

         return index < coupons.size();
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return coupons.get(index++);
         }
         return null;
      }		
   }
}