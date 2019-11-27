package com.bdata.cap.chapter7;

import com.bdata.cap.chapter6.Print;

import static com.bdata.cap.chapter6.Print.print;

public class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        Print.print("BoardGame constructor");
    }
}
