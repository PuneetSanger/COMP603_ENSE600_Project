// Connect4Board.java
package GUI;

import java.util.Arrays;

public final class Connect4Board {
    private final int ROWS = 6;
    private final int COLS = 7;
    private final int[][] board;

    public Connect4Board() {
        board = new int[ROWS][COLS];
        resetBoard();
    }

    // Resets the board
    public void resetBoard() {
        for (int[] row : board) {
            Arrays.fill(row, 0); // Use Arrays.fill for simplicity
        }
    }

    // Returns the value of a cell
    public int getCellValue(int row, int col) {
        return board[row][col];
    }

    // Drops the counter in the selected column
    public boolean dropCounter(int col, int player) {
        for (int row = ROWS - 1; row >= 0; row--) {
            if (board[row][col] == 0) {
                board[row][col] = player;
                return true;
            }
        }
        return false;
    }

    // Checks for a win
    public boolean checkWin() {
        return checkHorizontalWin() || checkVerticalWin() || checkDiagonalWin();
    }

    // Check for a draw
    public boolean isBoardFull() {
        return Arrays.stream(board[0]).noneMatch(cell -> cell == 0);
    }

    // Helper methods to check different win conditions
    private boolean checkHorizontalWin() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (hasFourInARow(board[row][col], row, col, 0, 1)) 
                    return true;
            }
        }
        return false;
    }

    private boolean checkVerticalWin() {
        for (int col = 0; col < COLS; col++) {
            for (int row = 0; row <= ROWS - 4; row++) {
                if (hasFourInARow(board[row][col], row, col, 1, 0)) 
                    return true;
            }
        }
        return false;
    }

    private boolean checkDiagonalWin() {
        // Diagonal (bottom-left to top-right) and (top-left to bottom-right)
        for (int row = 0; row <= ROWS - 4; row++) {
            for (int col = 0; col <= COLS - 4; col++) {
                if (hasFourInARow(board[row][col], row, col, 1, 1) ||
                    hasFourInARow(board[row + 3][col], row + 3, col, -1, 1))
                {
                    return true;
                }
            }
        }
        return false;
    }

    // Helper to check four in a row
    private boolean hasFourInARow(int cellValue, int row, int col, int rowInc, int colInc) {
        if (cellValue == 0) return false;
        for (int i = 1; i < 4; i++) {
            if (board[row + i * rowInc][col + i * colInc] != cellValue) {
                return false;
            }
        }
        return true;
    }
}
