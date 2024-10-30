package Database;

public class LeaderboardData implements Comparable<LeaderboardData> 
{
    private String playerName;
    private int wins;
    private int losses;

    public LeaderboardData(String playerName, int wins, int losses) 
    {
        this.playerName = playerName;
        this.wins = wins;
        this.losses = losses;
    }

    public String getPlayerName() 
    {
        return this.playerName;
    }

    public int getWins() 
    {
        return this.wins;
    }

    public int getLosses() 
    {
        return this.losses;
    }

    @Override
    public int compareTo(LeaderboardData o) 
    {
        return Integer.compare(this.wins, o.wins);
    }
}
