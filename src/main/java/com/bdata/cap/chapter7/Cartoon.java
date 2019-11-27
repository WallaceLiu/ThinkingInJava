package com.bdata.cap.chapter7;

import com.bdata.cap.chapter6.Print;

import static com.bdata.cap.chapter6.Print.print;

public class Cartoon extends Drawing {
    public Cartoon() {
        Print.print("Cartoon constructor");
    }

    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }

    /*output
    Art constructor
    Drawing constructor
    Cartoon constructor
     */
}
