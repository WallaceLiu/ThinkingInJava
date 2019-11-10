//: generics/CuriouslyRecurringGeneric.java
package bdata.cap.com.generics;

class GenericType<T> {}

public class CuriouslyRecurringGeneric
  extends GenericType<CuriouslyRecurringGeneric> {} ///:~
