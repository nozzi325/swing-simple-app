package commands;

import javax.swing.JTextArea;

public interface Command {
    void performAction(JTextArea textArea);
}
