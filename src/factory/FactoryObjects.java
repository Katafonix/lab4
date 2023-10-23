package factory;

import vehicles.Bus;
import vehicles.Car;
import vehicles.Truck;

public class FactoryObjects<T> {
    public T create(String[] parameters) {
        String objectType = parameters[1];
        int power = Integer.parseInt(parameters[2]);
        String manufacturer = parameters[3];

        switch (objectType) {
            case "Truck" -> {
                int capacity = Integer.parseInt(parameters[4]);
                return (T) new Truck(power, manufacturer, capacity);
            }
            case "Bus" -> {
                int capacity = Integer.parseInt(parameters[4]);
                return (T) new Bus(power, manufacturer, capacity);
            }
            case "Car" -> {
                int nDoors = Integer.parseInt(parameters[4]);
                int maxSpeed = Integer.parseInt(parameters[5]);
                return (T) new Car(power, manufacturer, nDoors, maxSpeed);
            }
            default -> throw new RuntimeException("Неизвестный объект");
        }
    }
}
