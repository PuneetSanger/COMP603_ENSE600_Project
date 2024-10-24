// OnePlayer.java
package GUI;

import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class SinglePlayer 
{
    private final GUIPlayingBoard boardPanel;
    private boolean isPlayerTurn;
    private final Random random;

    public SinglePlayer() 
    {
        JFrame frame = new JFrame("Connect 4 - Single Player");         //Create title at top of the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        boardPanel = new GUIPlayingBoard();
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(createButtonPanel(), BorderLayout.SOUTH);

        frame.setMinimumSize(new Dimension(700, 600));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

        isPlayerTurn = true;
        random = new Random();
    }

    private JPanel createButtonPanel() 
    {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 7));
        for (int col = 0; col < 7; col++) 
        {
            JButton button = new JButton(String.valueOf(col + 1));
            int finalCol = col;
            button.addActionListener(e -> {
                if (isPlayerTurn) 
                {
                    if (boardPanel.getCellValue(0, finalCol) == 0) 
                    
                    {   //Check if column is available
                        boardPanel.dropCoin(finalCol);
                        isPlayerTurn = false;   //Switch to computer's turn
                        computerTurn();
                    }
                }
            });
            buttonPanel.add(button);
        }
        return buttonPanel;
    }

    // Computer's turn logic
    private void computerTurn() 
    {
        Timer timer = new Timer(1000, e -> {        //Use timer so computer doesnt input column straight away
            int col;
            
            do 
            {
                col = random.nextInt(7); // Random column selection
            } 
            
            while (boardPanel.getCellValue(0, col) != 0); // Ensure the column is not full

            boardPanel.dropCoin(col);   //Drop the coin in the selected column
            isPlayerTurn = true;        //Switch back to the player's turn
        });
        timer.setRepeats(false);        //Ensure the action happens only once
        timer.start();
    }
}
