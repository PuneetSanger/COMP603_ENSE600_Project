package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * This class creates the Counter that will be used in other classes
 * 
 */
public class Counter extends JPanel
{
    private int player;
    private Color colour;           //Import java color library, will control the colour of the disk
    
    public Counter(int player)
    {
        this.player = player;
        this.colour = Color.WHITE;                  //All counters start off as white in the grid  
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
    
    public Color getColor()
    {
        return colour;
    }

}
