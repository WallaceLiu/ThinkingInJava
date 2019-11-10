//: chapter12/OnOffSwitch.java
// Why use finally?
package bdata.cap.com.chapter12;

public class OnOffSwitch {
  private static Switch sw = new Switch();
  public static void f()
  throws OnOffException1,OnOffException2 {throw new OnOffException1();}
  public static void main(String[] args) {
    try {
      sw.on();
      // Code that can throw chapter12...
      f();
      sw.off();
    } catch(OnOffException1 e) {
      System.out.println("OnOffException1");
      sw.off();
    } catch(OnOffException2 e) {
      System.out.println("OnOffException2");
      sw.off();
    }
  }
} /* Output:
on
off
*///:~
