package command;

import list.List;

import java.util.HashMap;
import java.util.Map;

public class CommandProcessor<T> {
    private final Map<String, Command<T>> commands = new HashMap<>();

    public void register(String name, Command<T> command) {
        commands.put(name, command);
    }

    void process(List<T> list, String line) {
        String[] parameters = line.split(" ");
        String commandName = parameters[0];

        Command<T> command = commands.get(commandName);
        if (command == null) throw new RuntimeException("Неизвестная команда: " + commandName);

        try {
            command.execute(list, parameters);
        } catch (RuntimeException e) {
            System.err.println("Ошибка при выполнении команды: " + e.getMessage());
        }
    }
}
