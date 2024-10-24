package GUI;

import java.awt.*;
import javax.swing.*;

public class Connect4GUI extends JFrame 
{
    private final GUIPlayingBoard boardPanel;

    public Connect4GUI() 
    {
        setTitle("Connect 4 Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     //Exit application when closing the frame
        setLayout(new BorderLayout());

        boardPanel = new GUIPlayingBoard();
        add(boardPanel, BorderLayout.CENTER);

        add(createButtonPanel(), BorderLayout.SOUTH);

        setMinimumSize(new Dimension(700, 600));            //Set size of the frame
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }

    //Create buttons associated with each column
    private JPanel createButtonPanel() 
    {
        JPanel gameButtons = new JPanel(new GridLayout(1, 7));      //Create buttons 1 - 7 
        for (int col = 0; col < 7; col++) 
        {
            JButton button = new JButton(String.valueOf(col + 1));
            
            int finalCol = col;
            button.addActionListener(e -> boardPanel.dropCoin(finalCol));
            gameButtons.add(button);
        }
        return gameButtons;
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(Connect4GUI::new);
    }
}
