package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class creates the Counter that will be further used to create the board grid
 * This class isn't being used right now
 */
public class Counter extends JPanel
{
    private final int player;
    private Color colour;           //Import java color library, will control the colour of the disc
    
    public Counter(int player)
    {
        this.player = player;
        this.colour = Color.WHITE;                  //All counters start off as white in the grid 
        this.setBackground(Color.BLUE);             //Set colour of background to be blue 
        setPreferredSize(new Dimension(100,100));   //Set size for the counter        
    }
    
    @Override 
    protected void paintComponent(Graphics g)           //Override the paint compoennt and draw the counter as a disk
    {
        super.paintComponent(g);
        g.setColor(colour);
        g.fillOval(10, 10, getWidth() - 20, getHeight() - 20);   //Create circle 
    }

    public int getPlayer()
    {
        return player;
    }
    
    public Color getColour()
    {
        return colour;
    }
    
    public void setColour(Color newColor)                //Method to repaint the counter 
    {
        this.colour = newColor;
        repaint();
    }
}
