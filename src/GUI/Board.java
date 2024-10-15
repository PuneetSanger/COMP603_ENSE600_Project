/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author jessielord
 */
public class Board {
    private final int[][] grid; // 0 = empty, 1 = Player 1, 2 = Player 2

    public Board() {
        grid = new int[6][7]; // 6 rows, 7 columns
    }

    // Method to drop a counter in a column
    public boolean dropCounter(int column, int player) {
        for (int row = 5; row >= 0; row--) {
            if (grid[row][column] == 0) { // Check if cell is empty
                grid[row][column] = player;
                return true; // Successful drop
            }
        }
        return false; // Column full
    }

    public int[][] getGrid() {
        return grid;
    }
    
    // Add methods to check for win conditions
}
