package command;

import list.List;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CommandReader<T> {
    private final CommandProcessor<T> commandProcessor;

    public CommandReader(CommandProcessor<T> commandProcessor) {
        this.commandProcessor = commandProcessor;
    }

    public void readFile(List<T> list, String filename) {
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                commandProcessor.process(list, scanner.nextLine());
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
}
