//: polymorphism/shape/Circle.java
package com.bdata.cap.polymorphism.shape;

import static mindview.util.Print.print;

public class Circle extends Shape {
    public void draw() {
        print("Circle.draw()");
    }

    public void erase() {
        print("Circle.erase()");
    }
} ///:~
