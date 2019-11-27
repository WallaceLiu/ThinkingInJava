package com.bdata.cap.chapter5;

// Demonstrates initialization order.
// When the constructor is called to create a
// Window object, you'll see a message:
public class OrderOfInitialization {
    public static void main(String[] args){
        House h = new House();
        h.f();
    }

    /*output
    Window(1)
    Window(2)
    Window(3)
    House()
    Window(33)
    f()
     */
}
