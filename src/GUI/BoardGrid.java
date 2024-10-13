package GUI;

import java.awt.GridLayout;
import javax.swing.JPanel;

//This class creates the Board grid using the Counter class

public class BoardGrid extends JPanel 
{

    //Constructor to initialize the grid
    public BoardGrid() 
    {
        this.setLayout(new GridLayout(6, 7));       //6 rows, 7 columns

        //For loop to create the grid for the connect 4 game 
        for (int j = 0; j < 6; j++)                 //Rows 
        {
            for (int i = 0; i < 7; i++)             //Columns 
            {
                Counter counter = new Counter(0);   //Create new instance of Counter object
                this.add(counter);                  //Add counter
            }
        }
    }
}

