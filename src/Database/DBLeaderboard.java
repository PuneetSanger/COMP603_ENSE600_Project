package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBLeaderboard 
{
    private DBManager dbManager;
    private Connection conn;
    private Statement statement;

    // Updated table name
    private static final String LEADERBOARD_TABLE = "LEADERBOARD";

    public DBLeaderboard() 
    {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
        try 
        {
            statement = conn.createStatement();
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }

    public void createLeaderboardTable() 
    {
        // Initialize the Leaderboard table
        checkExistingTable(LEADERBOARD_TABLE);        

        // Create table with PLAYER, WINS, and LOSSES columns
        String sqlCreateTable = "CREATE TABLE " + LEADERBOARD_TABLE + " (PLAYER VARCHAR(20) PRIMARY KEY, WINS INT DEFAULT 0, LOSSES INT DEFAULT 0)";
        dbManager.updateDB(sqlCreateTable);
    }

    public void updateTable(String playerName, boolean won) 
    {
        // Update the database with player name, wins, or losses
        if (isPlayerInDB(playerName)) 
        {
            if (won) 
            {
                incrementPlayerWins(playerName);
            } 
            else 
            {
                incrementPlayerLosses(playerName);
            }
        } 
        else 
        {
            // If player is not in the database, add them
            addPlayer(playerName, won);
        }
    }

    private void addPlayer(String playerName, boolean won) 
    {
        int wins = won ? 1 : 0;
        int losses = won ? 0 : 1;
        String sqlInsertRecords = "INSERT INTO " + LEADERBOARD_TABLE + " (PLAYER, WINS, LOSSES) VALUES ('" + playerName + "', " + wins + ", " + losses + ")";
        dbManager.updateDB(sqlInsertRecords);
    }

    public void getTable() 
    {
        // Return the database table
        try 
        {
            String query = "SELECT * FROM " + LEADERBOARD_TABLE;
            ResultSet rs = dbManager.queryDB(query);
            
            while (rs.next()) 
            {
                String playerName = rs.getString("PLAYER");
                int wins = rs.getInt("WINS");
                int losses = rs.getInt("LOSSES");
                System.out.println("Player: " + playerName + ", Wins: " + wins + ", Losses: " + losses);
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
    }

    public List<LeaderboardData> getLeaderboardData() 
    {
        // Retrieves player data from the database and stores it in a list of type LeaderboardData
        List<LeaderboardData> leaderboardData = new ArrayList<>();
        try 
        {
            String query = "SELECT * FROM " + LEADERBOARD_TABLE;
            ResultSet rs = dbManager.queryDB(query);
            
            while (rs.next()) 
            {
                String playerName = rs.getString("PLAYER");
                int wins = rs.getInt("WINS");
                int losses = rs.getInt("LOSSES");
                leaderboardData.add(new LeaderboardData(playerName, wins, losses));
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        return leaderboardData;
    }

    public boolean isPlayerInDB(String playerName) 
    {
        // Returns true if the input player name is in the database
        try 
        {
            String query = "SELECT * FROM " + LEADERBOARD_TABLE + " WHERE PLAYER = '" + playerName + "'";
            ResultSet rs = dbManager.queryDB(query);
            return rs.next(); // returns true if a result is found
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        
        return false;
    }

    public void incrementPlayerWins(String playerName) 
    {
        String query = "UPDATE " + LEADERBOARD_TABLE + " SET WINS = WINS + 1 WHERE PLAYER = '" + playerName + "'";
        dbManager.updateDB(query);
    }

    public void incrementPlayerLosses(String playerName) 
    {
        String query = "UPDATE " + LEADERBOARD_TABLE + " SET LOSSES = LOSSES + 1 WHERE PLAYER = '" + playerName + "'";
        dbManager.updateDB(query);
    }

    public void clearLeaderboard() 
    {
        String query = "DELETE FROM " + LEADERBOARD_TABLE;
        dbManager.updateDB(query);
    }

    public void closeConnection() 
    {
        this.dbManager.closeConnections();
    }

    public void checkExistingTable(String tableName) 
    {
        try 
        {
            ResultSet tables = conn.getMetaData().getTables(null, null, tableName, null);
            if (tables.next()) 
            {
                dbManager.updateDB("DROP TABLE " + tableName);
            }
        } 
        catch (SQLException ex) 
        {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}
