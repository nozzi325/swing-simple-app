package commands;

import javax.swing.*;

public class HelpCommand implements Command {
    @Override
    public void performAction(JTextArea textArea) {
        textArea.append("1) help - get list of all available commands\n");
        textArea.append("2) time - get current time\n");
        textArea.append("3) date - get current date\n");
        textArea.append("4) clean - clear output area\n");
    }
}
