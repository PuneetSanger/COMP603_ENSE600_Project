package GUI;

import GUI.Connect4Board;
import java.awt.*;
import javax.swing.*;

public class GUIPlayingBoard extends JPanel {
    private Connect4Board board;
    private int currentPlayer;
    private final int cellSize = 100; // Size of each cell

    public GUIPlayingBoard() {
        board = new Connect4Board();
        currentPlayer = 1; // Player 1 starts
        setLayout(new GridLayout(6, 7)); // 6 rows, 7 columns for Connect 4 grid

        // Initialize the grid with panels to represent the cells
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                add(new CellPanel(row, col));
            }
        }

        // Set preferred size to make the board larger on startup
        setPreferredSize(new Dimension(700, 600)); // Set preferred size for the panel
    }

    // Method to update the visual representation of the grid
    public void updateGridDisplay() {
        revalidate();
        repaint();
    }

    // Inner class to represent each cell on the board
    class CellPanel extends JPanel {
        private int row, col;

        public CellPanel(int row, int col) {
            this.row = row;
            this.col = col;
            setBackground(Color.BLUE); // Background color for the board
            setPreferredSize(new Dimension(cellSize, cellSize)); // Set cell size
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw white circle for an empty cell, yellow for player 1, red for player 2
            int cellValue = board.getCellValue(row, col);
            Color coinColor;
            switch (cellValue) {
                case 1: // Player 1
                    coinColor = Color.YELLOW;
                    break;
                case 2: // Player 2
                    coinColor = Color.RED;
                    break;
                default: // Empty cell
                    coinColor = Color.WHITE;
                    break;
            }

            // Draw the circle (coin)
            g.setColor(coinColor);
            int diameter = Math.min(getWidth(), getHeight()) - 20; // Ensure circle fits within cell
            g.fillOval(10, 10, diameter, diameter); // Draw circle with padding
        }
    }

    // Method to handle dropping a coin
    public void dropCoin(int col) {
        if (board.dropCounter(col, currentPlayer)) {
            updateGridDisplay(); // Update the GUI after dropping the coin
            if (board.checkWin()) {
                JOptionPane.showMessageDialog(this, "Player " + currentPlayer + " wins!");
                board.resetBoard();
            } else if (board.isBoardFull()) {
                JOptionPane.showMessageDialog(this, "It's a draw!");
                board.resetBoard();
            }
            currentPlayer = (currentPlayer == 1) ? 2 : 1; // Switch turns
        } else {
            JOptionPane.showMessageDialog(this, "Column full! Choose another one.");
        }
        updateGridDisplay();
    }
}
