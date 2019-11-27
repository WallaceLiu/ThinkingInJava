package com.bdata.cap.chapter7;

import static com.bdata.cap.chapter6.Print.*;

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
