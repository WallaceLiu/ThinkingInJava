//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)
package bdata.cap.com.generics;

interface Payable<T> {}

class Employee implements Payable<Employee> {}
class Hourly extends Employee
  implements Payable<Hourly> {} ///:~
