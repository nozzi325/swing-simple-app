import commands.*;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AppFrame extends JFrame{
    private final int WIDTH = 400;
    private final int HEIGHT = 415;
    private JTextArea outputArea;
    private JTextField inputField;
    private CommandHandler commandHandler;

    public AppFrame(){
        super("Swing App");
        setBounds(250,250,WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        commandHandler = new CommandHandler();

        inputField = new JTextField();
        inputField.setBounds(15,10,240,30);

        JButton applyButton = new JButton("Apply");
        int buttonWidth = (inputField.getWidth() - 20)/2;
        applyButton.setBounds(inputField.getX() + 250,inputField.getY(),buttonWidth,29);
        applyButton.setFocusPainted(false);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
        outputArea.setFont(new Font(Font.MONOSPACED, Font.BOLD, 12));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(inputField.getX(), inputField.getY() + 55,WIDTH - 40,300);

        applyButton.addActionListener(e-> {

            String command = inputField.getText().toLowerCase(Locale.ROOT).trim();

            if (command.isEmpty()){
                JOptionPane.showMessageDialog(null,"The command field is empty");
            } else {
                outputArea.append(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + ": "
                        + command + "\n");

                if (commandHandler.exists(command)){
                    commandHandler.getCommand(command).performAction(outputArea);
                } else {
                    outputArea.append("ERROR! Unknown command '" + command + "'\n");
                }

                outputArea.append("*******************************\n");
                inputField.setText("");
            }
        });

        getRootPane().setDefaultButton(applyButton);
        add(inputField);
        add(applyButton);
        add(scrollPane);
        setVisible(true);
    }
}