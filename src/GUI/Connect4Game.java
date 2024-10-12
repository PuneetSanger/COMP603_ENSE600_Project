package GUI;

import javax.swing.JFrame;

public class Connect4Game 
{
    
    private JFrame frame;                                       //The main game frame

    //Constructor to set up the JFrame
    public Connect4Game() 
    {
        frame = new JFrame("Connect 4");                       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Exit application when closing the frame
        frame.setSize(700, 600);                                //Set size of frame
        
        
        BoardGrid boardGrid = new BoardGrid();      //Create an instance of BoardGrid
        
        
        frame.add(boardGrid);                       //Add the grid to the JFrame
        
        
        frame.setVisible(true);                     //Make the frame visible
    }

    // Main method to create an instance of Connect4Game and show the frame
    public static void main(String[] args) 
    {
        new Connect4Game(); // Create and display the game frame
    }

}
