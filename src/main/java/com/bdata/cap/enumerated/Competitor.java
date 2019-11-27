//: enumerated/Competitor.java
// Switching one enum on another.
package com.bdata.cap.enumerated;

public interface Competitor<T extends Competitor<T>> {
  Outcome compete(T competitor);
} ///:~
