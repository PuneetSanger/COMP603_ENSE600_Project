/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import javax.swing.JFrame;

public class BoardJFrame 
{
     private final JFrame frame;                                       //The main game Jframe

    //Constructor to set up the JFrame
    public BoardJFrame() 
    {
        frame = new JFrame("Connect 4");                       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Exit application when closing the frame
        frame.setSize(700, 600);                                //Set size of frame
        
        BoardGrid boardGrid = new BoardGrid();      //Create an instance of BoardGrid
        
        frame.add(boardGrid);                       //Add the grid to the JFrame       
        frame.setVisible(true);                     //Make the frame visible  
    }
}
