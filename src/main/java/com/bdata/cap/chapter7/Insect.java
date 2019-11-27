package com.bdata.cap.chapter7;

import com.bdata.cap.chapter6.Print;

import static com.bdata.cap.chapter6.Print.print;

/**
 * Create by Intellij Idea.
 *
 * @Auhtor George
 * @Create on 2018/2/24
 */
public class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        Print.print("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        Print.print(s);
        return 47;
    }
}
