package commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JTextArea;

class HelpCommandTest {
    HelpCommand command;

    @BeforeEach
    void setUp() {
        command = new HelpCommand();
    }

    @Test
    void performAction_OK() {
        // given
        JTextArea jTextArea = new JTextArea();

        // when
        command.performAction(jTextArea);

        // verify
        Assertions.assertFalse(jTextArea.getText().isEmpty());
        Assertions.assertTrue(jTextArea.getText().contains("help"));
        Assertions.assertTrue(jTextArea.getText().contains("date"));
        Assertions.assertTrue(jTextArea.getText().contains("clean"));
        Assertions.assertTrue(jTextArea.getText().contains("time"));
    }
}