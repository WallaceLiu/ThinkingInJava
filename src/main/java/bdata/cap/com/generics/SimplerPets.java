//: generics/SimplerPets.java
package bdata.cap.com.generics;

import bdata.cap.com.net.mindview.util.New;
import bdata.cap.com.typeinfo.pets.Person;
import bdata.cap.com.typeinfo.pets.Pet;

import java.util.List;
import java.util.Map;

public class SimplerPets {
  public static void main(String[] args) {
    Map<Person, List<? extends Pet>> petPeople = New.map();
    // Rest of the code is the same...
  }
} ///:~
