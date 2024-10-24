/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class BoardGrid extends JPanel
{
     private final Connect4Board board; // Game logic board
    private final Counter[][] counters; // 6x7 grid of Counter objects

    //Constructor to initialize the grid
    public BoardGrid() 
    {
        this.setLayout(new GridLayout(6, 7)); // 6 rows, 7 columns
        board = new Connect4Board();          // Connect 4 game logic board
        counters = new Counter[6][7];         // 6 rows, 7 columns of Counter objects

        //Create the grid for the Connect 4 game
        for (int row = 0; row < 6; row++) 
        {
            for (int col = 0; col < 7; col++) 
            {
                counters[row][col] = new Counter(0); //Start with empty counters
                this.add(counters[row][col]);        //Add to the JPanel
            }
        }
    }

    //Method to update counters in the grid
    public void updateGridDisplay() 
    {
        //Loop through the grid and update each counter's color
        for (int rows = 0; rows < 6; rows++) 
        {
            for (int cols = 0; cols < 7; cols++) 
            {
                int cellValue = board.getCellValue(rows, cols);
                Color color = (cellValue == 1) ? Color.YELLOW : (cellValue == 2) ? Color.RED : Color.WHITE;
                counters[rows][cols].setColor(color);                            //Update the counter's color
            }
        }
        revalidate();
        repaint();          //Repaint the counter
    }

    // Method to drop a coin in the selected column
    public boolean dropCoin(int col, int player) 
    {
        if (board.dropCounter(col, player)) 
        {
            updateGridDisplay(); //Refresh the display after dropping the coin
            return true;
        }
        return false;
    }

    //Check win method
    public boolean checkWin() 
    {
        return board.checkWin();
    }

    //Check if board is full method
    public boolean isBoardFull() 
    {
        return board.isBoardFull();
    }

    public void resetBoard() 
    {
        board.resetBoard();     //Reset the game logic
        updateGridDisplay();    //Reset the visual board
    }
}
