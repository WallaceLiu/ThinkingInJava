//: generics/InstantiateGenericType.java
package bdata.cap.com.generics;

import static bdata.cap.com.net.mindview.util.Print.*;

class ClassAsFactory<T> {
	T x;

	public ClassAsFactory(Class<T> kind) {
		try {
			// 调用无参构造器
			x = kind.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}

//class Employee {
//}

public class InstantiateGenericType {
	public static void main(String[] args) {
		ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(
				Employee.class);
		print("ClassAsFactory<Employee> succeeded");
		try {
			ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(
					Integer.class);
		} catch (Exception e) {
			print("ClassAsFactory<Integer> failed");
		}
	}
} /*
 * Output: ClassAsFactory<Employee> succeeded 
 * ClassAsFactory<Integer> failed
 */// :~
