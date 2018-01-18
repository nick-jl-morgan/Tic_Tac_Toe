/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 *
 * @author Nicholas Morgan (#201335841) & Matthew King
 */

public class Board {

    private char[][] board = new char[3][3]; //creates a matrix of 3X3 characters

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct an empty board (contains all space char's).
     */
    public Board() {
        /*
         * TBD
         */
    	
    	for(int i = 0; i < board.length; i++) { //for loop through the rows
    		
    		for(int j = 0; j < board.length; j++) { //for loop through the columns
    			
    			board[i][j] = ' '; //sets empty characters in the board variable 
    			
        	}
    	}
    	
    }

    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
    	
        this.board=other.board; //set the current board to the board private variable
        
        this.board[move.getI()][move.getJ()]=move.getPiece(); //place the move on the board 
        
    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() 
    {
    	String bb=""; //initialization of string value
    	
    	for(int j = 0; j < 3; j++) //for loop through the columns 
    	{
    		
    		for(int i = 0; i < 3; i++)  //for loop through the rows
    		{
    			
    			bb +=" " + String.valueOf(board[i][j]) + " "; //converts the board of character to string values
    			
    			if (i != 2) //checks if the rows are not at the end to place the boarder for the board
    			{
     	           bb=bb +("|"); 
    	        }
    		
    		}
    		if(j !=2) //checks if the rows are not at the end to place the boarder for the board
    		{
    			
    			bb += "\n----------- \n" ; //
    			
    		}
    		
        }

		return bb; //return the string version of the board
       
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
    	
		return board[i][j]; //returns the current board position depending on i & j
     
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {

    	for(int j = 0; j < 3; j++) //for loop through the columns 
    	{
    		
    		for(int i = 0; i < 3; i++) //for loop through the rows 
    		{
    			
    			if(board[i][j]==' ') //checks if the board position is empty 
    			{
    				return false;
    			}
    			
    		}
    	}
    	return true;
    }
}
