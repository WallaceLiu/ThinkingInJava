//: annotations/database/Uniqueness.java
// Sample of nested annotations
package bdata.cap.com.annotations.database;

public @interface Uniqueness {
  Constraints constraints()
    default @Constraints(unique=true);
} ///:~
