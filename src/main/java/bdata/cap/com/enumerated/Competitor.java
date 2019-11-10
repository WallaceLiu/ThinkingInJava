//: enumerated/Competitor.java
// Switching one enum on another.
package bdata.cap.com.enumerated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
