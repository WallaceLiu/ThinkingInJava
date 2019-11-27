//: generics/Manipulator3.java
package com.bdata.cap.generics;

class Manipulator3 {
  private HasF obj;
  public Manipulator3(HasF x) { obj = x; }
  public void manipulate() { obj.f(); }
} ///:~
