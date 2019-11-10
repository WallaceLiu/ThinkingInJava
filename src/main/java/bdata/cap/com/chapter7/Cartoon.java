package bdata.cap.com.chapter7;

import static bdata.cap.com.chapter6.Print.print;

public class Cartoon extends Drawing {
    public Cartoon() {
        print("Cartoon constructor");
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
