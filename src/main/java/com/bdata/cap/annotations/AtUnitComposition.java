package com.bdata.cap.annotations;

//: annotations/AtUnitComposition.java
// Creating non-embedded tests.

import mindview.atunit.Test;
import mindview.util.OSExecute;

public class AtUnitComposition {
    AtUnitExample1 testObject = new AtUnitExample1();

    @Test
    boolean _methodOne() {
        return testObject.methodOne().equals("This is methodOne");
    }

    @Test
    boolean _methodTwo() {
        return testObject.methodTwo() == 2;
    }

    public static void main(String[] args) throws Exception {
        OSExecute.command("java mindview.atunit.AtUnit AtUnitComposition");
    }
}
/* Output:
annotations.AtUnitComposition
  . _methodOne
  . _methodTwo This is methodTwo

OK (2 tests)
*///:~
