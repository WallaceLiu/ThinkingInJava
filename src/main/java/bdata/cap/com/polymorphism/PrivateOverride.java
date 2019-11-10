//: polymorphism/PrivateOverride.java
// Trying to override a private method.
package bdata.cap.com.polymorphism;

import static bdata.cap.com.net.mindview.util.Print.*;

public class PrivateOverride {
  private void f() { print("private f()"); }
  public static void main(String[] args) {
    PrivateOverride po = new Derived();
    po.f();
  }
}

class Derived extends PrivateOverride {
  public void f() { print("public f()"); }
} /* Output:
private f()
*///:~
