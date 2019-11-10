//: generics/ReturnGenericType.java
package bdata.cap.com.generics;

class ReturnGenericType<T extends HasF> {
  private T obj;
  public ReturnGenericType(T x) { obj = x; }
  public T get() { return obj; }
} ///:~
