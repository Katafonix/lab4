package vehicles;

public class Bus extends Vehicle {
    private final int capacity;

    public Bus(int power, String manufacturer, int capacity) {
        super(power, manufacturer);
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "capacity=" + capacity +
                ", power=" + power +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}