package GUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author puneetsanger
 */
public class GUIGame extends JPanel 
{
    public GUIGame()
    {
        // Add BoardGrid to the GUI's layout
        this.setLayout(new BorderLayout());
        this.add(new BoardGrid(), BorderLayout.CENTER);  // Add BoardGrid to the center of the GUI
        this.setSize(800, 700);  // Set the size of the frame
        this.setVisible(true);  // Make the frame visible     
    }
    
    
}


