package GUI;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Connect4GUI extends JFrame {
    private GUIPlayingBoard boardPanel;

    public Connect4GUI() {
        setTitle("Connect 4 Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new GUIPlayingBoard();
        add(boardPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 7)); // Buttons for each column

        for (int col = 0; col < 7; col++) {
            final int column = col; // To use in the action listener
            JButton button = new JButton(String.valueOf(col + 1)); // Column numbers 1-7
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    boardPanel.dropCoin(column); // Drop coin in selected column
                }
            });
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.SOUTH); // Add buttons at the bottom

        // Set minimum size for the frame
        setMinimumSize(new Dimension(700, 600)); // Minimum size to ensure visibility

        // Add a listener to maintain aspect ratio
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension size = getSize();
                int newWidth = size.width;
                int newHeight = (int) (newWidth * (6.0 / 7)); // Keep aspect ratio of 6:7
                setSize(newWidth, newHeight);
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Connect4GUI());
    }
}
