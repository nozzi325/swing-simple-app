package commands;

import javax.swing.*;

public class CleanCommand implements Command {
    @Override
    public void performAction(JTextArea textArea) {
        textArea.setText("");
    }
}
