package MainMenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import GUI.TwoPlayerLauncher;
import GUI.OnePlayer;  // Import the OnePlayer class

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

        // Single Player Button
        JButton singlePlayerButton = new JButton("Single Player");
        singlePlayerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        singlePlayerButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                new OnePlayer();  // Launch One Player game
                dispose();        // Close the main menu
            }
        });
        add(singlePlayerButton, gbc);

        // Two Player Button
        gbc.gridy = 2;
        JButton twoPlayerButton = new JButton("Two Player");
        twoPlayerButton.setFont(new Font("Arial", Font.PLAIN, 16));
        twoPlayerButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                TwoPlayerLauncher twoPlayerLauncher = new TwoPlayerLauncher();  // Launch Two Player game
                twoPlayerLauncher.launchTwoPlayerGame();
                dispose(); // Close the main menu
            }
        });
        add(twoPlayerButton, gbc);
        
         // Leaderboard Button
        gbc.gridy = 3;
        JButton leaderboardButton = new JButton("Leaderboard");
        leaderboardButton.setFont(new Font("Arial", Font.PLAIN, 16));
        leaderboardButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Enter Leaderboard code here
                dispose(); // Close the main menu
            }
        });
        add(leaderboardButton, gbc);

        // Quit Button
        gbc.gridy = 4;
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("Arial", Font.PLAIN, 16));
        quitButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                System.exit(0); // Exit the application
            }
        });
        add(quitButton, gbc);

        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new MainMenu());
    }
}
