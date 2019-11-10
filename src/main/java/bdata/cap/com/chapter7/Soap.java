package bdata.cap.com.chapter7;

import static bdata.cap.com.chapter6.Print.*;

public class Soap {
    private String s;
    Soap() {
        print("Soap()");
        //在类的构造器中初始化引用
        s = "Constructed";
    }

    @Override
    public String toString() {
        return s;
    }
}
