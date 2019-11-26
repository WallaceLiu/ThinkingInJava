//: interfaces/interfaceprocessor/Apply.java
package bdata.cap.com.interfaces.interfaceprocessor;
import static mindview.util.Print.*;

public class Apply {
  public static void process(Processor p, Object s) {
    print("Using Processor " + p.name());
    print(p.process(s));
  }
} ///:~
