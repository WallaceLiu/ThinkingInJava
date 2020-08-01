package mytest;

import com.bdata.cap.typeinfo.pets.Cat;
import com.bdata.cap.typeinfo.pets.Dog;

/**
 * @program ThinkingInJava
 * @description:
 * @author: liuning11
 * @create: 2019/11/27
 */
@FilterBuiltIn(name = "bx", clazz = Cat.class)
@FilterBuiltIn(name = "cms", clazz = Dog.class)
@FilterBuiltIn(name = "crowd", clazz = Dog.class)
public class MyFilter {

    public void handle() {

    }
}
