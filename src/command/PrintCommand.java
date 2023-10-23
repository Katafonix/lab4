package command;

import list.List;

public class PrintCommand<T> implements Command<T> {

    @Override
    public void execute(List<T> list, String[] parameters) {
        list.print();
    }
}
