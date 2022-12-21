package commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class TimeCommandTest {
    TimeCommand command;

    @BeforeEach
    void setUp() {
        command = new TimeCommand();
    }

    @Test
    void performAction_OK() {
        // given
        JTextArea jTextArea = new JTextArea();
        String expectedValue = "Current time is "
                + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                + "\n";

        // when
        command.performAction(jTextArea);

        // verify
        Assertions.assertFalse(jTextArea.getText().isEmpty());
        Assertions.assertEquals(expectedValue,jTextArea.getText());
    }
}