package mytest;


import java.lang.annotation.*;

//@Target(ElementType.TYPE) // Applies to classes only
//@Retention(RetentionPolicy.RUNTIME)
@Repeatable(value = FilterBuiltIns.class)
public @interface FilterBuiltIn {
    String name();

    Class<?> clazz();
} ///:~
