package commands;

import java.util.Map;
import java.util.HashMap;

public class CommandHandler {
    private Map<String, Command> commands = new HashMap<>();

    public CommandHandler() {
        initializeCommands();
    }

    private void initializeCommands() {
        addCommand("clean", new CleanCommand());
        addCommand("date", new DateCommand());
        addCommand("time", new TimeCommand());
        addCommand("help", new HelpCommand());
    }

    public void addCommand(String name, Command command) {
        commands.put(name, command);
    }

    public boolean exists(String name) {
        return commands.containsKey(name);
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }
}
