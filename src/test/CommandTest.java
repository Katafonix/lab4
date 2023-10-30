package test;

import command.*;
import factory.FactoryObjects;
import list.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import vehicles.Vehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CommandTest {

    @Test
    public void testAddCommand() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        List<Vehicle> list = new List<>();
        CommandProcessor<Vehicle> processor = new CommandProcessor<>();
        processor.register("ADD", new AddCommand<>(factory));
        processor.register("PRINT", new PrintCommand<>());
        processor.register("REM", new RemoveCommand<>());

        processor.process(list, "ADD Car 100 Manufacturer 4 200");
        assertEquals(1, list.getSize());
    }

    @Test
    public void testPrintCommand() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        List<Vehicle> list = new List<>();
        CommandProcessor<Vehicle> processor = new CommandProcessor<>();
        processor.register("ADD", new AddCommand<>(factory));
        processor.register("PRINT", new PrintCommand<>());
        processor.register("REM", new RemoveCommand<>());

        processor.process(list, "ADD Car 100 Manufacturer 4 200");
        processor.process(list, "PRINT");  // You need to check the console output manually
    }

    @Test
    public void testRemoveCommand() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        List<Vehicle> list = new List<>();
        CommandProcessor<Vehicle> processor = new CommandProcessor<>();
        processor.register("ADD", new AddCommand<>(factory));
        processor.register("PRINT", new PrintCommand<>());
        processor.register("REM", new RemoveCommand<>());

        processor.process(list, "ADD Car 100 Manufacturer 4 200");
        processor.process(list, "REM Manufacturer");
        assertEquals(0, list.getSize());
    }

    @Test
    public void testUnknownCommand() {
        FactoryObjects<Vehicle> factory = new FactoryObjects<>();
        List<Vehicle> list = new List<>();
        CommandProcessor<Vehicle> processor = new CommandProcessor<>();
        processor.register("ADD", new AddCommand<>(factory));
        processor.register("PRINT", new PrintCommand<>());
        processor.register("REM", new RemoveCommand<>());
        assertThrows(RuntimeException.class, () -> processor.process(list, "unknown"));
    }
}
