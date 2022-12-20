package commands;

import javax.swing.JTextArea;

public class CleanCommand implements Command {
    @Override
    public void performAction(JTextArea textArea) {
        textArea.setText("");
    }
}
