
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AppFrame extends JFrame{
    private final int WIDTH = 400;
    private final int HEIGHT = 415;
    private JTextArea outputArea;
    private JTextField inputField;

    public AppFrame(){
        super("Swing App");
        setBounds(250,250,WIDTH,HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

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

        add(inputField);
        add(applyButton);
        add(scrollPane);
        setVisible(true);
    }
}