import commands.CommandHandler;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AppFrame extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 415;
    private JTextArea outputArea;
    private JTextField inputField;
    private CommandHandler commandHandler;

    public AppFrame() {
        super("Swing App");
        initializeFrame();
        createComponents();
        showWelcomeMessage();
    }

    private void initializeFrame() {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        commandHandler = new CommandHandler();
    }

    private void createComponents() {
        inputField = new JTextField();
        inputField.setBounds(15, 10, 240, 30);

        JButton applyButton = createApplyButton();
        outputArea = createOutputArea();

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(
                inputField.getX(),
                inputField.getY() + 55,
                WIDTH - 40,
                300
        );

        addComponentsToFrame(inputField, applyButton, scrollPane);
    }

    private JButton createApplyButton() {
        JButton applyButton = new JButton("Apply");
        int buttonWidth = (inputField.getWidth() - 20) / 2;
        applyButton.setBounds(
                inputField.getX() + 250,
                inputField.getY(),
                buttonWidth,
                29
        );
        applyButton.setFocusPainted(false);

        applyButton.addActionListener(e -> handleApplyButtonAction());

        getRootPane().setDefaultButton(applyButton);
        return applyButton;
    }

    private JTextArea createOutputArea() {
        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        area.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));
        return area;
    }

    private void handleApplyButtonAction() {
        String command = inputField.getText().toLowerCase(Locale.ROOT).trim();

        if (command.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The command field is empty");
        } else {
            appendToOutputArea(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))
                    + ": " + command + "\n");

            if (commandHandler.exists(command)) {
                commandHandler.getCommand(command).performAction(outputArea);
            } else {
                appendToOutputArea("ERROR! Unknown command '" + command + "'\n");
            }

            appendToOutputArea("*******************************\n");
            inputField.setText("");
        }
    }

    private void appendToOutputArea(String text) {
        outputArea.append(text);
    }

    private void addComponentsToFrame(JTextField inputField, JButton applyButton, JScrollPane scrollPane) {
        add(inputField);
        add(applyButton);
        add(scrollPane);
        setVisible(true);
    }

    private void showWelcomeMessage() {
        appendToOutputArea("Welcome to the Swing App!\n");
        appendToOutputArea("Available commands:\n");
        appendToOutputArea("1) help - get list of all available commands\n");
        appendToOutputArea("2) time - get current time\n");
        appendToOutputArea("3) date - get current date\n");
        appendToOutputArea("4) clean - clear output area\n");
        appendToOutputArea("*******************************\n");
    }
}
