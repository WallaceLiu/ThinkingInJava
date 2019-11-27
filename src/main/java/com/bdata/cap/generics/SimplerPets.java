//: generics/SimplerPets.java
package com.bdata.cap.generics;

import com.bdata.cap.typeinfo.pets.Person;
import com.bdata.cap.typeinfo.pets.Pet;
import mindview.util.New;

import java.util.List;
import java.util.Map;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~
