package GUI;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *  This class creates the user name input for the single player
 *  and two player game mode
 */
public class PlayerInputDialog extends JDialog 
{
    private JTextField player1NameField;
    private JTextField player2NameField;
    private JButton startGameButton;
    private String player1Name;
    private String player2Name;
    private boolean isTwoPlayerMode;

    public PlayerInputDialog(JFrame parent, boolean isTwoPlayerMode) 
    {
        super(parent, "Enter Player Name:", true);      //Enter a name for single player
        this.isTwoPlayerMode = isTwoPlayerMode;
        initializeSinglePlayerComponents();
    }

    //Method for single player name input 
    private void initializeSinglePlayerComponents() 
    {
        //Single player mode - only asks for player 1 name
        player1NameField = new JTextField("Player 1", 20);      //Create new text field
        startGameButton = new JButton("Start Game");            //Create new button
        
        //Two player mode - asks for player 1 and player 2 name 
        if(isTwoPlayerMode)     //Pass boolean two player mode through the constructor 
        {
            player2NameField = new JTextField("Player 2", 20);
        }
        
        //Start button
        startGameButton.addActionListener(e -> {
            player1Name = player1NameField.getText();
            
            if(isTwoPlayerMode)
            {
                player2Name = player2NameField.getText();
            }
            dispose();     //Close the dialog
        });

        //Create the single player panel to hold the components
        JPanel nameInputPanel = new JPanel();   //New Instance 
        nameInputPanel.add(new JLabel("Enter Player 1 Name:"));
        nameInputPanel.add(player1NameField);
        
        //Create the two player panel to hold the componenets 
        if(isTwoPlayerMode)
        {
            nameInputPanel.add(new JLabel("Enter Player 2 Name:"));
            nameInputPanel.add(player2NameField);
        }
        
        nameInputPanel.add(startGameButton);
        add(nameInputPanel);
        pack();
        setLocationRelativeTo(getParent());     //Set location of panel
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //Get method for player 1 name
    public String getPlayer1Name() 
    {
        return player1Name;     //Return the player 1 name
    }
    
    //Get method for player 2 name
    public String getPlayer2Name()
    {
        return player2Name;     //Return the player 2 name 
    }
}

