//: reusing/SpaceShip.java
package com.bdata.cap.reusing;

import com.bdata.cap.chapter7.SpaceShipControls;

public class SpaceShip extends SpaceShipControls {
    private String name;

    public SpaceShip(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
} ///:~
