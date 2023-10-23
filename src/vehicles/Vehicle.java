package vehicles;

import java.util.Objects;

public abstract class Vehicle {
    protected int power;
    protected String manufacturer;

    protected Vehicle(int power, String manufacturer) throws RuntimeException {
        this.power = power;
        if (!Character.isUpperCase(manufacturer.charAt(0)) || !manufacturer.chars().allMatch(Character::isLetter))
            throw new RuntimeException("Некорректный параметр manufacturer");
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof String) {
            return Objects.equals(manufacturer, o);
        }
        return false;
    }
}