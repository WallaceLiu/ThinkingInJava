package bdata.cap.com.chapter7;

public class SpaceShip extends bdata.cap.com.chapter7.SpaceShipControls {
    private String name;
    public SpaceShip(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        SpaceShip protector = new SpaceShip("NSEA Protector");
        protector.forward(100);
    }
}
