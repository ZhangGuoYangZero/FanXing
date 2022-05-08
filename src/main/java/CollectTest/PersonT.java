package CollectTest;

import java.util.ArrayList;
import java.util.Iterator;

public class PersonT <A>{
    //这种方式定义的泛型数组无法使用
   public A[] name0  =  (A[]) new Object[5];

   //改用arraylist集合
   public ArrayList<A> name = new ArrayList<>(5);

   public Iterator<A> Iterator() {
         return null;
   }
}


