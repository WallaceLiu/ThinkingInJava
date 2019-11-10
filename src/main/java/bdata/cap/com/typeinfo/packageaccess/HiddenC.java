//: typeinfo/packageaccess/HiddenC.java
package bdata.cap.com.typeinfo.packageaccess;
import bdata.cap.com.typeinfo.interfacea.*;
import static bdata.cap.com.net.mindview.util.Print.*;

class C implements A {
  public void f() { print("public C.f()"); }
  public void g() { print("public C.g()"); }
  void u() { print("package C.u()"); }
  protected void v() { print("protected C.v()"); }
  private void w() { print("private C.w()"); }
}

public class HiddenC {
  public static A makeA() { return new C(); }
} ///:~
