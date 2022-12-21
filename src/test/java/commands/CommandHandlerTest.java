package commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandHandlerTest {
    CommandHandler commandHandler;

    @BeforeEach
    void setUp() {
        commandHandler = new CommandHandler();
    }

    @Test
    void exists_OK() {
        // given
        String commandName = "clean";

        // when
        boolean result = commandHandler.exists(commandName);

        // verify
        Assertions.assertTrue(result);
    }

    @Test
    void exists_False_WhenCommandDoesNotExist() {
        // given
        String commandName = "incorrect_command";

        // when
        boolean result = commandHandler.exists(commandName);

        // verify
        Assertions.assertFalse(result);
    }

    @Test
    void getCommand_OK() {
        // given
        String commandName = "clean";

        // when
        Command command = commandHandler.getCommand(commandName);

        // verify
        Assertions.assertNotNull(command);
    }

    @Test
    void getCommand_Null_WhenCommandDoesNotExist() {
        // given
        String commandName = "incorrect_command";

        // when
        Command command = commandHandler.getCommand(commandName);

        // verify
        Assertions.assertNull(command);
    }
}