//: generics/CompilerIntelligence.java
package bdata.cap.com.generics;

import bdata.cap.com.chapter5.Apple;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {
  public static void main(String[] args) {
    List<? extends Fruit> flist =
      Arrays.asList(new Apple());
    Apple a = (Apple)flist.get(0); // No warning
    flist.contains(new Apple()); // Argument is 'Object'
    flist.indexOf(new Apple()); // Argument is 'Object'
  }
} ///:~
