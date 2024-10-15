/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author jessielord
 */
public class Connect4Board {
    private final int ROWS = 6;
    private final int COLS = 7;
    private int[][] board;

    public Connect4Board() {
        board = new int[ROWS][COLS]; // 6 rows and 7 columns for Connect 4
        resetBoard();
    }

    // Method to reset the board
    public void resetBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                board[row][col] = 0; // 0 indicates an empty cell
            }
        }
    }

    // Method to get the value of a specific cell on the board
    public int getCellValue(int row, int col) {
        return board[row][col];
    }

    // Method to drop a counter in a column
    // Player is either 1 (Player 1) or 2 (Player 2)
    // Returns true if the counter was successfully dropped, false if the column is full
    public boolean dropCounter(int col, int player) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == 0) { // Find the lowest empty row in the column
                board[row][col] = player;
                return true; // Counter was successfully dropped
            }
        }
        return false; // Column is full
    }

    // Method to check if the current player has won the game
    public boolean checkWin() {
        // Check all possible winning combinations (horizontal, vertical, diagonal)

        // Horizontal check
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (board[row][col] != 0 &&
                    board[row][col] == board[row][col + 1] &&
                    board[row][col] == board[row][col + 2] &&
                    board[row][col] == board[row][col + 3]) {
                    return true;
                }
            }
        }

        // Vertical check
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (board[row][col] != 0 &&
                    board[row][col] == board[row + 1][col] &&
                    board[row][col] == board[row + 2][col] &&
                    board[row][col] == board[row + 3][col]) {
                    return true;
                }
            }
        }

        // Diagonal (bottom-left to top-right) check
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (board[row][col] != 0 &&
                    board[row][col] == board[row + 1][col + 1] &&
                    board[row][col] == board[row + 2][col + 2] &&
                    board[row][col] == board[row + 3][col + 3]) {
                    return true;
                }
            }
        }

        // Diagonal (top-left to bottom-right) check
        for (int row = 3; row < ROWS; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (board[row][col] != 0 &&
                    board[row][col] == board[row - 1][col + 1] &&
                    board[row][col] == board[row - 2][col + 2] &&
                    board[row][col] == board[row - 3][col + 3]) {
                    return true;
                }
            }
        }

        return false; // No win found
    }

    // Method to check if the board is full (draw situation)
    public boolean isBoardFull() {
        for (int col = 0; col < COLS; col++) {
            if (board[0][col] == 0) {
                return false; // There is still space in at least one column
            }
        }
        return true; // All columns are full
    }
}
