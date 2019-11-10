//: generics/NonCovariantGenerics.java
// {CompileTimeError} (Won't compile)
package bdata.cap.com.generics;

import bdata.cap.com.chapter5.Apple;

import java.util.ArrayList;
import java.util.List;

public class NonCovariantGenerics {
  // Compile Error: incompatible types:
  List<Fruit> flist = new ArrayList<Apple>();
} ///:~
