package command;

import list.List;

public class RemoveCommand<T> implements Command<T> {
    @Override
    public void execute(List<T> list, String[] parameters) {
        if (parameters.length != 2) throw new RuntimeException("Некорректное количество параметров для команды REM");
        String manufacturer = parameters[1];
        list.remove(manufacturer);
    }
}
