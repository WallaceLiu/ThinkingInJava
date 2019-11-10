//: chapter12/NeverCaught.java
// Ignoring RuntimeExceptions.
// {ThrowsException}
package bdata.cap.com.chapter12;

public class NeverCaught {
  static void f() {
    throw new RuntimeException("From f()");
  }
  static void g() {
    f();
  }
  public static void main(String[] args) {
    g();
  }
} ///:~
