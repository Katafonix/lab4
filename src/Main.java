import command.*;
import factory.FactoryObjects;
import list.List;
import vehicles.Vehicle;

public class Main {

    public static void main(String[] args) {
        CommandProcessor<Vehicle> commandProcessor = new CommandProcessor<>();
        commandProcessor.register("ADD", new AddCommand<>(new FactoryObjects<>()));
        commandProcessor.register("REM", new RemoveCommand<>());
        commandProcessor.register("PRINT", new PrintCommand<>());

        CommandReader<Vehicle> commandReader = new CommandReader<>(commandProcessor);

        List<Vehicle> list = new List<>();

        commandReader.readFile(list, "commands.txt");
    }
}