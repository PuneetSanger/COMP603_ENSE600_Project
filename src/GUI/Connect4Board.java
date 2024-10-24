/*
    This class handles the board, counter placing, win logic and resetting the board

*/
package GUI;

import java.util.Arrays;

public final class Connect4Board 
{
    private final int ROWS = 6;     //Number of rows
    private final int COLS = 7;     //Number of columns 
    private final int[][] board;    //Intialise board as a 2D array

    public Connect4Board() 
    {
        board = new int[ROWS][COLS];        //Board is intialised by rows and columns, creating a 6x7 grid
        resetBoard();                       //Sets all cells in the board to empty
    }

    // Resets the board
    public void resetBoard() 
    {
        for (int[] row : board) 
        {
            Arrays.fill(row, 0); //Arrays.fill sets all elements in each row of the board array to 0
        }
    }

    // Returns the value of a cell
    public int getCellValue(int row, int col) 
    {
        return board[row][col];
    }

    // Drops the counter in the column that is selected
    public boolean dropCounter(int col, int player) 
    {
        for (int row = ROWS - 1; row >= 0; row--)   //Checks rows 0 - 5
        {
            if (board[row][col] == 0)               //If an empty cell is found the cell is set to the player
            {
                board[row][col] = player;
                return true;
            }
        }
        return false;
    }

    //Checks for a win condition
    public boolean checkWin() 
    {
        return checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin();    //Returns the three type of ways you can win
    }

    //Check for a draw
    public boolean isBoardFull() 
    {
        return Arrays.stream(board[0]).noneMatch(cell -> cell == 0);            //If no empty cells in the top row are found, board is full
    }

    //Helper methods to check different win conditions
    private boolean checkHorizontalWin() 
    {
        for (int row = 0; row < ROWS; row++) 
        {
            for (int col = 0; col <= COLS - 4; col++) 
            {
                if (hasFourInARow(board[row][col], row, col, 0, 1)) 
                    return true;
            }
        }
        return false;
    }

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
}
