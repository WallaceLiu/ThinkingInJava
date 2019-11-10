//: generics/CheckedList.java
// Using Collection.checkedList().
package bdata.cap.com.generics;

import bdata.cap.com.typeinfo.pets.Cat;
import bdata.cap.com.typeinfo.pets.Dog;
import bdata.cap.com.typeinfo.pets.Pet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs1 = new ArrayList<Dog>();
        oldStyleMethod(dogs1); // Quietly accepts a Cat
        List<Dog> dogs2 = Collections.checkedList(
                new ArrayList<Dog>(), Dog.class);
        try {
            oldStyleMethod(dogs2); // Throws an exception
        } catch (Exception e) {
            System.out.println(e);
        }
        // Derived types work fine:
        List<Pet> pets = Collections.checkedList(
                new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        /* Output:
            java.lang.ClassCastException: Attempt to insert class typeinfo.pets.Cat element into collection with element type class typeinfo.pets.Dog
        */
        //   pets.add(new Cat());
    }
}
