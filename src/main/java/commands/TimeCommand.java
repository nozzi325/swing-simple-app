package commands;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand implements Command{
    @Override
    public void performAction(JTextArea textArea) {
        textArea.append("Current time is " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
    }
}
