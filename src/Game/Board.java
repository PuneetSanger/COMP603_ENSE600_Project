package Game;
//Come back and make changes to the board class

public final class Board 
{
    int ROWS = 6;                            //6 columns, ROWS is a global variable 
    int COLS = 7;                            //7 columns standard grid size for connect 4, COLS is a global variable
    
    String[][] boardArray;                  //Instance variable of 2D board array
    int[] columnArray;                           //Instance variable for column height
    
    //Board constructor 
    public Board()                          
    {
        this.boardArray = new String[ROWS][COLS];           //Instantiate the boardArray with rows and columns
        this.columnArray = new int[COLS];                             
        this.initializeBoard();
             
    }
    
    public String[][] getBoardArray()           //Get method for Board Array
    {
        return this.boardArray;
    }
    
    public int[] getColumnArray()               //Get method for Column Array
    {
        return this.columnArray;
    }
    
    public void updateColumnArray(int col)      //Updates the column from user input, column increments from 0 
    {
        this.columnArray[col]++;                        
    }
                
    public void initializeBoard()
    {
        for (int i = 0; i < ROWS; i++)           //For loop to iterate through each row
        {
            for (int j = 0; j < COLS; j++)      //For loop to iterate through each column
            {
                this.boardArray[i][j] = ". ";   //The boards rows and columns are set to a dot  
            }                                  
        }
    }
    
    
    public void displayBoard()
    {
        for(int i = 0; i < ROWS; i++)        //Loop through each row
       
        {
            for(int j = 0; j < COLS; j++)    //Loop through each column
            {
                System.out.print(this.boardArray[i][j]);    //Print each cell in the row
            }
            
            System.out.println();       //Move to the next line after printing out a row
            
        }
    }
    
    public void updateBoard(int col, String symbol)     //This functions updates the board from the user input
    {
        int row = this.getColumnArray()[col];           
        this.getBoardArray()[this.ROWS - row][col] = symbol;            //Place the symbol in the calculated row
    }
    
    public boolean isFull()     //Function to calculate if the board is full or not 
    {   
        for (int j = 0; j < COLS; j++)
        {
            for (int i = 0; i < ROWS; i++)
            {
                if (boardArray[i][j].equals(". "))
                {
                    return false; // If a dot is found, the board is not full
                }
            }
        }   
        return true;        //No dots found, meaning that the board is full
    }    
        
    public boolean isConnect4(Player currentPlayer)
    {
        String symbol = currentPlayer.getSymbol();
        String[][] board = this.getBoardArray();
        
        //Check for horizontal connect 4 win 
        for (int row = 0; row < ROWS; row++) 
        {
            for (int col = 0; col <= COLS - 4; col++) 
            {
                if (board[row][col].equals(symbol) && 
                    board[row][col + 1].equals(symbol) &&                //Columns are incremented to check for this win 
                    board[row][col + 2].equals(symbol) &&                
                    board[row][col + 3].equals(symbol)) 
                {
                    return true;
                }
            }
        }

        //Check for vertical connect 4 win
        for (int row = 0; row <= ROWS - 4; row++) 
        {
            for (int col = 0; col < COLS; col++) 
            {
                if (board[row][col].equals(symbol) && 
                    board[row + 1][col].equals(symbol) &&                //Rows are simply incremented to check for 
                    board[row + 2][col].equals(symbol) &&                //this win
                    board[row + 3][col].equals(symbol)) 
                {
                    return true;
                }
            }
        }

        //Check for negative slope diagonal connect 4 win
        for (int row = 3; row < ROWS; row++) 
        {
            for (int col = 0; col <= COLS - 4; col++) 
            {
                if (board[row][col].equals(symbol) && 
                    board[row - 1][col + 1].equals(symbol) &&            //Rows are decremented and colummns are
                    board[row - 2][col + 2].equals(symbol) &&            //incremented to check for the negative slop
                    board[row - 3][col + 3].equals(symbol)) 
                {
                    return true;
                }
            }
        }

        //Check for positive slope diagonal connect 4 win 
        for (int row = 0; row <= ROWS - 4; row++) 
        {
            for (int col = 0; col <= COLS - 4; col++) 
            {
                if (board[row][col].equals(symbol) && 
                    board[row + 1][col + 1].equals(symbol) &&            //Both rows and columns are incremented
                    board[row + 2][col + 2].equals(symbol) &&            //to check for this win
                    board[row + 3][col + 3].equals(symbol))  
                {
                    return true;
                }
            }
        }

        return false;
    }        

    
}
