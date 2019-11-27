//: generics/ExplicitTypeSpecification.java
package com.bdata.cap.generics;

import com.bdata.cap.typeinfo.pets.Person;
import com.bdata.cap.typeinfo.pets.Pet;
import mindview.util.New;

import java.util.List;
import java.util.Map;

public class ExplicitTypeSpecification {
  static void f(Map<Person, List<Pet>> petPeople) {}
  public static void main(String[] args) {
    f(New.<Person, List<Pet>>map());
  }
} ///:~
