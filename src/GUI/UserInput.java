package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Consumer;

public class UserInput extends JFrame {
    private JTextField nameField;
    private JLabel promptLabel;

    public UserInput(String prompt, Consumer<String> onNameEntered) {
        setTitle("Name Entry");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and configure label
        promptLabel = new JLabel(prompt);
        add(promptLabel);

        // Create and configure text field
        nameField = new JTextField(20);
        add(nameField);

        // Add action listener for enter key
        nameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                onNameEntered.accept(name); // Pass the name to the callback
                dispose(); // Close the input window after submission
            }
        });

        // Set minimum size for the window
        setMinimumSize(new Dimension(300, 150));
        setSize(400, 200);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserInput("Enter your name:", name -> {
            JOptionPane.showMessageDialog(null, "Hello, " + name + "!");
        }));
    }
}
