package commands;

import javax.swing.JTextArea;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand implements Command{
    @Override
    public void performAction(JTextArea textArea) {
        textArea.append("Current time is " + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + "\n");
    }
}
