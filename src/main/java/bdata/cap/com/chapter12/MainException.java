//: chapter12/MainException.java
package bdata.cap.com.chapter12;

import java.io.*;

public class MainException {
  // Pass all chapter12 to the console:
  public static void main(String[] args) throws Exception {
    // Open the file:
    FileInputStream file =
      new FileInputStream("MainException.java");
    // Use the file ...
    // Close the file:
    file.close();
  }
} ///:~
