package bdata.cap.com.generics;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

// generic class MyGeneric
class MyGeneric<T> {

    private T key;

    public MyGeneric(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }
}

// generic interface MyGenerator
interface MyGenerator<T> {
    public T next();
}

// also pass T
class FruitGenerator<T> implements MyGenerator<T> {
    @Override
    public T next() {
        return null;
    }
}

// not pass T
class FruitGenerator2 implements MyGenerator<String> {

    private String[] fruits = new String[]{"Apple", "Banana", "Pear"};

    @Override
    public String next() {
        Random rand = new Random();
        return fruits[rand.nextInt(3)];
    }
}

public class GenericDemoFirst {

    public static void main(String[] args) {
        MyGeneric<Integer> genericInt = new MyGeneric<>(123456);
        MyGeneric<String> genericStr = new MyGeneric<>("key_str");
        System.out.println("key is " + genericInt.getKey());
        System.out.println("key is " + genericStr.getKey());
        /* Output:
        key is 123456
        key is key_str
        *///:~

        MyGeneric<Integer> gInteger = new MyGeneric<>(123);
        showKeyValue_1(gInteger);
        /* Output:
        key value is 123
        *///:~
    }

    // generic wildcard
    public static void showKeyValue_1(MyGeneric<?> obj) {
        System.out.println("key value is " + obj.getKey());
    }
}
