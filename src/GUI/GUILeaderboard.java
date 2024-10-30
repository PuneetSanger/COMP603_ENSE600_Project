package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class GUILeaderboard extends JFrame 
{
    private JTable leaderboardTable;
    private DefaultTableModel tableModel;

    public GUILeaderboard() 
    {
        setTitle("Leaderboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        // Create a table model with column names
        tableModel = new DefaultTableModel(new String[]{"Player Name", "Wins", "Losses"}, 0);
        leaderboardTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(leaderboardTable);

        JButton clearButton = new JButton("Clear Leaderboard");
        clearButton.addActionListener(e -> clearLeaderboard());

        // Load leaderboard data when the GUI is created
        loadLeaderboard();

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(clearButton, BorderLayout.SOUTH);
    }

    private void loadLeaderboard() 
    {
        List<String[]> leaderboardData = readLeaderboardFromFile();
        for (String[] entry : leaderboardData) 
        {
            tableModel.addRow(entry);
        }
    }

    private List<String[]> readLeaderboardFromFile() 
    {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Leaderboard.txt"))) 
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                String[] parts = line.split(","); // Assuming CSV format
                data.add(parts);
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return data;
    }

    private void clearLeaderboard() 
    {
        tableModel.setRowCount(0); // Clear the table
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Leaderboard.txt"))) 
        {
            // Clear the file content
            bw.write("");
            JOptionPane.showMessageDialog(this, "Leaderboard cleared successfully!");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
