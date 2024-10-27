/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

public class Connect4Board 
{
    private final int[][] board;
    private static final int ROWS = 6, COLS = 7;

    public Connect4Board() 
    {
        board = new int[ROWS][COLS]; // Initialize empty board
    }

    //Method to drop a counter in the specified column
    public boolean dropCounter(int col, int player) 
    {
        for (int row = ROWS - 1; row >= 0; row--) 
        {
            if (board[row][col] == 0) 
            {
                board[row][col] = player; // Place the counter
                return true;
            }
        }
        return false; // Column is full
    }
    
    public int getCellValue(int row, int col) 
    {
        return board[row][col];
    }

    //Check for win
    public boolean checkWin() 
    {
        
        return checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin();
    }
    
    //Check win method for horizontal connect 4
    private boolean checkHorizontalWin() 
    {
        for (int row = 0; row < ROWS; row++)                //This method checks for both negative and positive 
        {                                                   //slope wins 
            for (int col = 0; col <= COLS - 4; col++) 
            {
                if (hasFourInARow(board[row][col], row, col, 0, 1)) 
                    return true;
            }
        }
        return false;
    }
    
    //Check for vertical win
    private boolean checkVerticalWin() 
    {
        for (int col = 0; col < COLS; col++) 
        {
            for (int row = 0; row <= ROWS - 4; row++) 
            {
                if (hasFourInARow(board[row][col], row, col, 1, 0)) 
                    return true;
            }
        }
        return false;
    }
     
     private boolean checkDiagonalWin() 
    {
        //Check for diagonal win
        for (int row = 0; row <= ROWS - 4; row++) 
        {
            for (int col = 0; col <= COLS - 4; col++)                   //This accounts for positive slope and
            {                                                           //negative slope diagonal wins 
                if (hasFourInARow(board[row][col], row, col, 1, 1) ||
                    hasFourInARow(board[row + 3][col], row + 3, col, -1, 1))
                {
                    return true;
                }
            }
        }
        return false;
    }
     
     //Helper method to check four in a row
    private boolean hasFourInARow(int cellValue, int row, int col, int rowInc, int colInc) 
    {
        if (cellValue == 0) return false;
        
        for (int i = 1; i < 4; i++) 
        {
            if (board[row + i * rowInc][col + i * colInc] != cellValue) 
            {
                return false;
            }
        }
        return true;
    }
    
    //This method checks whether or not the board is full
    public boolean isBoardFull() 
    {
        for (int col = 0; col < COLS; col++) 
        {
            if (board[0][col] == 0) 
            {
                return false;
            }
        }
        return true;
    }

    //This method resets the board and replaces it with empty counters
    public void resetBoard() 
    {
        for (int row = 0; row < ROWS; row++) 
        {
            for (int col = 0; col < COLS; col++) 
            {
                board[row][col] = 0; // Clear the board
            }
        }
    }
}