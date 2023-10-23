package vehicles;

public class Car extends Vehicle {
    private final int nDoors;
    private final int maxSpeed;

    public Car(int power, String manufacturer, int nDoors, int maxSpeed) throws RuntimeException {
        super(power, manufacturer);
        if (!(nDoors >= 2 && nDoors <= 5))
            throw new RuntimeException("Некорректный параметр nDoors, параметр должен быть в диапозоне от 2 до 5");
        this.nDoors = nDoors;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "nDoors=" + nDoors +
                ", maxSpeed=" + maxSpeed +
                ", power=" + power +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}