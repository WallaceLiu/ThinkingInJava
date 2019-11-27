//: annotations/AtUnitExternalTest.java
// Creating non-embedded tests.
package com.bdata.cap.annotations;

import mindview.atunit.Test;
import mindview.util.OSExecute;

public class AtUnitExternalTest extends AtUnitExample1 {
    @Test
    boolean _methodOne() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return methodTwo() == 2;
    }

    public static void main(String[] args) {
        OSExecute.command("java mindview.atunit.AtUnit AtUnitExternalTest");
    }
} /* Output:
annotations.AtUnitExternalTest
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
