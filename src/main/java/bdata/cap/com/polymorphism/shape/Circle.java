//: polymorphism/shape/Circle.java
package bdata.cap.com.polymorphism.shape;

import static bdata.cap.com.net.mindview.util.Print.print;

public class Circle extends Shape {
    public void draw() {
        print("Circle.draw()");
    }

    public void erase() {
        print("Circle.erase()");
    }
} ///:~
