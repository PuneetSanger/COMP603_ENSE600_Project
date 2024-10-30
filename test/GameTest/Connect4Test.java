package GameTest;

import GUI.Connect4Board;

import static org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


/**
 *  This class contains the JUnit test cases
 * 
 */
public class Connect4Test 
{
    private Connect4Board board;
    
    public Connect4Test()
    {
        
    }
   
    
    @Before                         //Setup
    public static void setupClass() //Method to run before each test case
    {
        //Connect4Board board = new Connect4Board();
    }
    
    @After                              //Teardown
    public static void tearDownClass()  //Method to run after each test case
    {
        
    }
    
    @Before
    public void setup()
    {
        board = new Connect4Board();
        int player = 1;
    }
    
    @After 
    public void tearDown()
    {
        
    }
    
    //Test case for vertical win
    @Test
    public void testVerticalWin()
    {
        //board = new Connect4Board();      //New instance of the board
        int player = 1;
        int cols = 0;
        
        for(int rows = 0; rows < 4; rows++)
        {
            board.dropCounter(rows,player);
        }
        
        assertTrue(board.checkWin());
        
    }
    
    //Test case for horizontal win
    @Test
    public void testHorizontalWin()
    {
        int player = 1;
        
        for(int cols = 0; cols < 4; cols++)
        {
            board.dropCounter(cols, player);
        }
        
        assertTrue(board.checkWin());
        
    }
    
    //Test case for diagonal win
    @Test 
    public void testDiagonalWin()
    {
        int player = 1;
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < i; j++)
            {
                board.dropCounter(i, 2);
            }
            
            board.dropCounter(i, player);
        }
        
        assertTrue(board.checkWin());
    }
    
    //Test case for board full
    @Test
    public void testBoardFull()
    {
        int player = 1;
        //Populate the whole board
        for(int cols = 0; cols < 7; cols++)
        {
            for(int rows = 0; rows < 6; rows++)
            {
                board.dropCounter(cols, player);
                player = 3 - player;                //This allows the players to alternate
            }
        }
        
        assertTrue(board.isBoardFull());
    }
    
    //Test case for reset board
    @Test
    public void testResetBoard()
    {
        int player = 1;
        for(int cols = 0; cols < 4; cols++)
        {
            board.dropCounter(cols, player);
        }
        
        board.resetBoard();
        
        for(int rows = 0; rows < 6; rows++)
        {
            for(int cols = 0; cols < 7; cols++)
            {
                assertEquals(0, board.getCellValue(rows, cols));
            }
        }
    }

    private void assertTrue(boolean checkWin) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void assertEquals(int i, int cellValue) 
    {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
