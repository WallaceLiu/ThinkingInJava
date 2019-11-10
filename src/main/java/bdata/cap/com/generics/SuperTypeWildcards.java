//: generics/SuperTypeWildcards.java
package bdata.cap.com.generics;

//import bdata.cap.com.chapter5.Apple;

import java.util.List;

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
} ///:~
