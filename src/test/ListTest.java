package test;

import list.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicles.Bus;
import vehicles.Car;
import vehicles.Vehicle;

import static org.junit.jupiter.api.Assertions.*;

public class ListTest {

    @Test
    public void pushAndGetSize() {
        List<Vehicle> list = new List<>();
        list.push(new Car(100, "Manufacturer", 4, 200));
        list.push(new Bus(200, "OtherManufacturer", 50));
        assertEquals(2, list.getSize());
    }

    @Test
    public void remove() {
        List<Vehicle> list = new List<>();
        Vehicle vehicle = new Car(100, "Manufacturer", 4, 200);
        list.push(vehicle);
        list.remove("Manufacturer");
        assertEquals(0, list.getSize());
    }

    @Test
    public void isEmpty() {
        List<Vehicle> list = new List<>();
        assertTrue(list.isEmpty());
        list.push(new Car(100, "Manufacturer", 4, 200));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testRemoveNonExistent() {
        List<Vehicle> list = new List<>();
        list.push(new Car(100, "Manufacturer", 4, 200));
        list.remove("ZIL");
        assertEquals(1, list.getSize());
    }
}
