package MainMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.TwoPlayerLauncher;
import GUI.SinglePlayer;
import GUI.UserInput;
import Database.Player1One;
import Database.Player1Two;
import Database.Player2Two;

public class MainMenu extends JFrame 
{
    public MainMenu() 
    {
        setTitle("Connect 4 - Main Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.CYAN); // Set background color

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding between buttons
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;

        // Title
        JLabel titleLabel = new JLabel("Connect 4", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridwidth = 2; // Span across 2 columns
        add(titleLabel, gbc);

        gbc.gridwidth = 1; // Reset for buttons
        gbc.gridy = 1;

        // Single Player Mode Button
        JButton onePlayerButton = new JButton("Single Player");
        onePlayerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        onePlayerButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ask for Player 1's name
                new UserInput("Enter Player 1's name:", name -> {
                    Player1One player1 = new Player1One(name);
                    JOptionPane.showMessageDialog(MainMenu.this, "Hello, " + player1.getName() + "! You are playing with the yellow coin.");

                    // Launch the One Player game
                    new SinglePlayer();
                    dispose(); // Close the main menu
                });
            }
        });
        
        add(onePlayerButton, gbc);

        //Two Player Mode Button
        gbc.gridy = 2;
        JButton twoPlayerButton = new JButton("Two Player");
        twoPlayerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        twoPlayerButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ask for Player 1's name
                new UserInput("Enter Player 1's name:", name1 -> {
                    Player1Two player1 = new Player1Two(name1);
                    JOptionPane.showMessageDialog(MainMenu.this, "Hello, " + player1.getName() + "! You are playing with the yellow coin.");

                    // Ask for Player 2's name
                    new UserInput("Enter Player 2's name:", name2 -> {
                        Player2Two player2 = new Player2Two(name2);
                        JOptionPane.showMessageDialog(MainMenu.this, "Hello, " + player2.getName() + "! You are playing with the red coin.");

                        // Launch the Two Player game
                        TwoPlayerLauncher twoPlayerLauncher = new TwoPlayerLauncher();
                        twoPlayerLauncher.launchTwoPlayerGame();
                        dispose(); // Close the main menu
                    });
                });
            }
        });
        add(twoPlayerButton, gbc);

        // Leaderboard Button
        gbc.gridy = 3;
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setFont(new Font("Arial", Font.PLAIN, 16));
        leaderboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enter Leaderboard code here
                dispose(); // Close the main menu
            }
        });
        add(leaderboardButton, gbc);

        // Quit Button
        gbc.gridy = 4;
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Exit the application
            }
        });
        add(quitButton, gbc);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu());
    }
}
