package commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JTextArea;
import java.time.LocalDate;

class DateCommandTest {

    DateCommand command;

    @BeforeEach
    void setUp() {
        command = new DateCommand();
    }

    @Test
    void performAction_OK() {
        // given
        JTextArea jTextArea = new JTextArea();
        String expectedValue = "Current date is " + LocalDate.now() + "\n";

        // when
        command.performAction(jTextArea);

        // verify
        Assertions.assertFalse(jTextArea.getText().isEmpty());
        Assertions.assertEquals(expectedValue,jTextArea.getText());
    }
}