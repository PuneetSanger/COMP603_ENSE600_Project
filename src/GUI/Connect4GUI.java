package GUI;

import java.awt.*;
import javax.swing.*;

public class Connect4GUI extends JFrame 
{
    private final GUIPlayingBoard boardPanel;

    public Connect4GUI() 
    {
        setTitle("Connect 4 Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        boardPanel = new GUIPlayingBoard();
        add(boardPanel, BorderLayout.CENTER);

        add(createButtonPanel(), BorderLayout.SOUTH);

        setMinimumSize(new Dimension(700, 600));
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    private JPanel createButtonPanel() 
    {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 7));
        for (int col = 0; col < 7; col++) 
        {
            JButton button = new JButton(String.valueOf(col + 1));
            int finalCol = col;
            button.addActionListener(e -> boardPanel.dropCoin(finalCol));
            buttonPanel.add(button);
        }
        return buttonPanel;
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(Connect4GUI::new);
    }
}
