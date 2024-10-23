package Database;

public class Player2Two {
    private String name;
    private String colour;

    public Player2Two(String name) {
        this.name = name;
        this.colour = "Red"; // Assuming Player 2 gets Red 
    }

    public String getName() {
        return name;
    }

    public String getColour() {
        return colour;
    }
}
