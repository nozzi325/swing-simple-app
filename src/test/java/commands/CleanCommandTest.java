package commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JTextArea;

class CleanCommandTest {

    CleanCommand command;

    @BeforeEach
    void setUp() {
        command = new CleanCommand();
    }

    @Test
    void performAction_OK() {
        // given
        JTextArea jTextArea = new JTextArea();
        jTextArea.append("str1");
        jTextArea.append("str2");

        // when
        command.performAction(jTextArea);

        // verify
        Assertions.assertTrue(jTextArea.getText().isEmpty());
    }
}