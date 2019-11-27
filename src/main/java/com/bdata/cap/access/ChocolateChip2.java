//: access/ChocolateChip2.java
package com.bdata.cap.access;

import com.bdata.cap.access.cookie2.*;
import com.bdata.cap.access.cookie2.Cookie;

public class ChocolateChip2 extends Cookie {
  public ChocolateChip2() {
   System.out.println("ChocolateChip2 constructor");
  }
  public void chomp() { bite(); } // Protected method
  public static void main(String[] args) {
    ChocolateChip2 x = new ChocolateChip2();
    x.chomp();
  }
} /* Output:
Cookie constructor
ChocolateChip2 constructor
bite
*///:~
