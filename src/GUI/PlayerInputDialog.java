package GUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PlayerInputDialog extends JDialog 
{
    private JTextField player1NameField;
    private JTextField player2NameField;
    private JButton startGameButton;
    private String player1Name;
    private String player2Name;
    private final boolean isTwoPlayerMode;

    public PlayerInputDialog(JFrame parent, boolean isTwoPlayerMode) 
    {
        super(parent, "Enter Player Name:", true); // Enter a name for single player
        this.isTwoPlayerMode = isTwoPlayerMode;
        initializeComponents();
    }

    // Method for initializing components based on game mode
    private void initializeComponents() 
    {
        // Single player mode - only asks for player 1 name
        player1NameField = new JTextField("Player 1", 20); // Create new text field
        startGameButton = new JButton("Start Game"); // Create new button

        // Two player mode - asks for player 1 and player 2 name
        if (isTwoPlayerMode)    // Pass boolean two player mode through the constructor
        { 
            player2NameField = new JTextField("Player 2", 20);
        }

        // Start button action
        startGameButton.addActionListener(e -> {
            player1Name = player1NameField.getText();
            
            if (isTwoPlayerMode) 
            {
                player2Name = player2NameField.getText();
            }
            dispose(); // Close the dialog
        });

        // Create the input panel to hold components
        JPanel nameInputPanel = new JPanel(new GridLayout(0, 1));
        nameInputPanel.add(new JLabel("Enter Player 1 Name:"));
        nameInputPanel.add(player1NameField);

        // Add player 2 name input field only if in Two Player mode
        if (isTwoPlayerMode) 
        {
            nameInputPanel.add(new JLabel("Enter Player 2 Name:"));
            nameInputPanel.add(player2NameField);
        }

        nameInputPanel.add(startGameButton);
        add(nameInputPanel);
        pack();
        setLocationRelativeTo(getParent()); // Set location of panel
    }

    // Get method for player 1 name
    public String getPlayer1Name() 
    {
        return player1Name; // Return the player 1 name
    }

    // Get method for player 2 name
    public String getPlayer2Name() 
    {
        return player2Name; // Return the player 2 name
    }
}
