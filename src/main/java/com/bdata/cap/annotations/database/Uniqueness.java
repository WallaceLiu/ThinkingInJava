package com.bdata.cap.annotations.database;

//: annotations/database/Uniqueness.java
// Sample of nested annotations

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
} ///:~
