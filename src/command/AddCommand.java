package command;

import factory.FactoryObjects;
import list.List;

public class AddCommand<T> implements Command<T> {

    private final FactoryObjects<T> factoryObjects;

    public AddCommand(FactoryObjects<T> factoryObjects) {
        this.factoryObjects = factoryObjects;
    }

    @Override
    public void execute(List<T> list, String[] parameters) {
        list.push(factoryObjects.create(parameters));
    }
}
