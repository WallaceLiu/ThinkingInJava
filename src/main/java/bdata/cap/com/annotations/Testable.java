//: annotations/Testable.java
package bdata.cap.com.annotations;

import bdata.cap.com.net.mindview.atunit.*;

public class Testable {
  public void execute() {
    System.out.println("Executing..");
  }
  @Test void testExecute() { execute(); }
} ///:~
