//: annotations/ExtractInterface.java
// APT-based annotation processing.
package com.bdata.cap.annotations;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {
    String value();
} ///:~
