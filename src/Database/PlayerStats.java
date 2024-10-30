package Database;

public class PlayerStats 
{
    private final String playerName;  //Variables
    private int wins;
    private int losses;
    private int draws;
    
    public PlayerStats(String playerName, int wins, int losses)     //Constructor that passes player name, wins and losses
    {
        this.playerName = playerName;
        this.wins = wins;
        this.losses = losses;
    }
    
    public String getPlayerName()      //Get method for player name 
    {
        return playerName;              //Return player name 
    }
        
    public int getWins()                //Get method for player wins
    {   
        return wins;                    //Return the number of wins by the player
    }
    
    public int getLosses()              //Get method for player losses
    {
        return losses;                  //Return number of losses by the player
    }
    
    public int getDraws()              //Get method for player draws
    {
        return draws;                  //Return number of draws by the player
    }
    
    public void incrementWins()         //Increment wins function 
    {
        this.wins++;                    //Increment the wins 
    }
    
    public void incrementLosses()       //Increment losses function
    {
        this.losses++;                  //Increment the losses
    }
    
    public void incrementDraws()       //Increment draws function
    {
        this.draws++;                  //Increment the draws
    }
}
