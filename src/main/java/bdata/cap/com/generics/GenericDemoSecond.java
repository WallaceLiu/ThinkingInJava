package bdata.cap.com.generics;


import java.util.Random;


class MyFruit {
    @Override
    public String toString() {
        return "fruit";
    }
}

class MyApple extends MyFruit {
    @Override
    public String toString() {
        return "apple";
    }
}

class MyPerson {
    @Override
    public String toString() {
        return "Person";
    }
}

class MyGenerateTest<T> {
    public void show_1(T t) {
        System.out.println(t.toString());
    }

    public <T> void show_2(T t) {
        System.out.println(t.toString());
    }

    public <E> void show_3(E t) { // E可以为任意类型。可以类型与T相同，也可以不同
        System.out.println(t.toString());
    }
}

public class GenericDemoSecond {

    public static void main(String[] args) {
        Apple apple = new Apple();
        MyPerson person = new MyPerson();

        MyGenerateTest<Fruit> generateTest = new MyGenerateTest<>();
        generateTest.show_1(apple);
        generateTest.show_2(apple);
        generateTest.show_2(person);
        generateTest.show_3(apple);
        generateTest.show_3(person);
    }
}
