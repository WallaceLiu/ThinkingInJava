//: generics/SuperTypeWildcards.java
package com.bdata.cap.generics;

//import com.bdata.cap.chapter5.Apple;

import java.util.List;

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }
} ///:~
