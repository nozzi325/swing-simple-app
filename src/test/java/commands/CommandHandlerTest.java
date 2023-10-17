package commands;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandHandlerTest {
    private CommandHandler commandHandler;

    @BeforeEach
    void setUp() {
        commandHandler = new CommandHandler();
    }

    @Test
    void testExistsForExistingCommand() {
        // given
        String commandName = "clean";

        // when
        boolean result = commandHandler.exists(commandName);

        // then
        Assertions.assertTrue(result);
    }

    @Test
    void testExistsForNonExistentCommand() {
        // given
        String commandName = "incorrect_command";

        // when
        boolean result = commandHandler.exists(commandName);

        // then
        Assertions.assertFalse(result);
    }

    @Test
    void testGetCommandForExistingCommand() {
        // given
        String commandName = "clean";

        // when
        Command command = commandHandler.getCommand(commandName);

        // then
        Assertions.assertNotNull(command);
    }

    @Test
    void testGetCommandForNonExistentCommand() {
        // given
        String commandName = "incorrect_command";

        // when
        Command command = commandHandler.getCommand(commandName);

        // then
        Assertions.assertNull(command);
    }
}