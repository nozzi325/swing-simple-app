package commands;

import javax.swing.JTextArea;
import java.time.LocalDate;

public class DateCommand implements Command{
    @Override
    public void performAction(JTextArea textArea) {
        textArea.append("Current date is " + LocalDate.now() + "\n");
    }
}
