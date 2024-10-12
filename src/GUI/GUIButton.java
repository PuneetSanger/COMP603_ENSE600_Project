package GUI;

import java.awt.Button;
import javax.swing.JButton;

/**
 *
 * @author puneetsanger
 */
public class GUIButton extends JButton 
{
    private int num;
    
    public GUIButton(int num)
    {
       this.num = num;
       
       this.setText("Number");
    }
   
}
