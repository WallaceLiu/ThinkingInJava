//: reusing/Hide.java
// Overloading a base-class method name in a derived
// class does not hide the base-class versions.
package com.bdata.cap.reusing;


public class Hide {
    public static void main(String[] args) {
        Bart b = new Bart();
        b.doh(1);
        b.doh('x');
        b.doh(1.0f);
        b.doh(new Milhouse());
    }
} /* Output:
doh(float)
doh(char)
doh(float)
doh(Milhouse)
*///:~
