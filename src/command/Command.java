package command;

import list.List;

public interface Command<T> {
    void execute(List<T> list, String[] parameters);
}
