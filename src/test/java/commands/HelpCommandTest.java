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
        String text = jTextArea.getText();
        Assertions.assertFalse(text.isEmpty());
        Assertions.assertTrue(text.contains("1) help - get list of all available commands"));
        Assertions.assertTrue(text.contains("2) time - get current time"));
        Assertions.assertTrue(text.contains("3) date - get current date"));
        Assertions.assertTrue(text.contains("4) clean - clear output area"));
    }
}