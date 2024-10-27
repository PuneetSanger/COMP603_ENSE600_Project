package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author puneetsanger
 */
public class PlayerInputDialog extends JDialog 
{
    private JTextField playerNameField;
    private JButton startGameButton;
    private String player1Name;

    public PlayerInputDialog(JFrame parent) 
    {
        super(parent, "Enter Player Name", true); // Corrected the title to "Player Name"
        initializeComponents(); // Fixed typo in method name
    }

    private void initializeComponents() 
    { // Fixed the method name
        playerNameField = new JTextField("Player 1", 20);
        startGameButton = new JButton("Start Game");

        startGameButton.addActionListener(e -> {
            player1Name = playerNameField.getText();
            dispose(); // Close the dialog
        });

        // Create the panel to hold the components
        JPanel nameInputPanel = new JPanel(); // Corrected to 'JPanel'
        nameInputPanel.add(playerNameField);
        nameInputPanel.add(startGameButton);
        add(nameInputPanel);

        pack();
        setLocationRelativeTo(getParent()); // Fixed method call
    }

    public String getPlayerName() 
    {
        return player1Name; // Return the player name
    }
}

