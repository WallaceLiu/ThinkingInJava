//: generics/ExplicitTypeSpecification.java
package bdata.cap.com.generics;

import bdata.cap.com.net.mindview.util.New;
import bdata.cap.com.typeinfo.pets.Person;
import bdata.cap.com.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
