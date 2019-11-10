//: concurrency/SerialNumberGenerator.java
package bdata.cap.com.concurrency;

public class SerialNumberGenerator {
  private static volatile int serialNumber = 0;
  public static int nextSerialNumber() {
    return serialNumber++; // Not thread-safe
  }
} ///:~
