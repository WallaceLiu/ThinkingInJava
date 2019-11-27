//: generics/LimitsOfInference.java
package com.bdata.cap.generics;

import com.bdata.cap.typeinfo.pets.*;
import com.bdata.cap.typeinfo.pets.Person;
import com.bdata.cap.typeinfo.pets.Pet;

import java.util.*;

public class LimitsOfInference {
  static void
  f(Map<Person, List<? extends Pet>> petPeople) {}
  public static void main(String[] args) {
    // f(New.map()); // Does not compile
  }
} ///:~
