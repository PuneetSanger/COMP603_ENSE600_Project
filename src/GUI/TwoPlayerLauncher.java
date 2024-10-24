package GUI;

import javax.swing.SwingUtilities;

public class TwoPlayerLauncher {

    public void launchTwoPlayerGame() 
    {
        SwingUtilities.invokeLater(() -> 
        {
            TwoPlayer twoPlayerGame = new TwoPlayer();  // Initialize the TwoPlayer game logic
            twoPlayerGame.startGame();  // Start the game
        });
    }
}
