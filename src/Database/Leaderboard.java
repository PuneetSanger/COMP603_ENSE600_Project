package Database;

import java.io.*;
import java.util.*;

public class Leaderboard 
{
    private File file;

    public Leaderboard(String fileName) 
    {
        file = new File(fileName);
        if (!file.exists()) 
        {
            try 
            {
                file.createNewFile();
            } 
            
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }

    public void recordResult(String playerName, String result) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) 
        {
            writer.write(playerName + ": " + result);
            writer.newLine();
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public List<String> readLeaderboard() 
    {
        List<String> results = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) 
        {
            String line;
            while ((line = reader.readLine()) != null) 
            {
                results.add(line);
            }
        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        return results;
    }
}
