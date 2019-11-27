//: generics/CuriouslyRecurringGeneric.java
package com.bdata.cap.generics;

class GenericType<T> {}

public class CuriouslyRecurringGeneric
  extends GenericType<CuriouslyRecurringGeneric> {} ///:~
