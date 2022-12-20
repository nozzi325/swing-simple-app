package commands;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private Map<String, Command> commands;

    public CommandHandler(){
        commands = new HashMap<>();
        commands.put("clean", new CleanCommand());
        commands.put("date", new DateCommand());
        commands.put("time", new TimeCommand());
        commands.put("help", new HelpCommand());
    }

    public boolean exists(String name){
        return commands.containsKey(name);
    }

    public Command getCommand(String name){
        return commands.get(name);
    }
}
