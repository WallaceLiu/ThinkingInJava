//: annotations/SimulatingNull.java
package bdata.cap.com.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {
    int id() default -1;

    String description() default "";
} ///:~
