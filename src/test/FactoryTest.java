package test;

import factory.FactoryObjects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicles.Car;
import vehicles.Vehicle;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FactoryTest {

    @Test
    public void testCreateObject() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        Vehicle vehicle = factory.create(new String[]{"", "Car", "100", "Manufacturer", "4", "200"});
        assertTrue(vehicle instanceof Car);
    }

    @Test
    public void testCreateWithInvalidType() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        String[] parameters = {"", "invalid", "150", "Volvo", "15000"};
        assertThrows(RuntimeException.class, () -> factory.create(parameters));
    }

    @Test
    public void testCreateWithInvalidPower() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        String[] parameters = {"", "Truck", "invalid", "Volvo", "15000"};
        assertThrows(NumberFormatException.class, () -> factory.create(parameters));
    }

    @Test
    public void testCreateWithInvalidManufacturer() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        String[] parameters = {"", "Truck", "100", "15", "15000"};
        assertThrows(RuntimeException.class, () -> factory.create(parameters));
    }

    @Test
    public void testCreateWithInvalidCapacity() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        String[] parameters = {"", "Bus", "150", "Mercedes", "invalid"};
        assertThrows(NumberFormatException.class, () -> factory.create(parameters));
    }

    @Test
    public void testCreateWithInvalidNumberOfDoors() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        String[] parameters = {"", "Car", "100", "Toyota", "invalid", "180"};
        assertThrows(NumberFormatException.class, () -> factory.create(parameters));
    }

    @Test
    public void testCreateWithInvalidMaxSpeed() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        String[] parameters = {"", "Car", "100", "Toyota", "4", "invalid"};
        assertThrows(NumberFormatException.class, () -> factory.create(parameters));
    }
}
