/**
 * An immutable class that represents the state of the 3×3 tic-tac-toe board.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

public class Board {

    private char[][] board = new char[3][3];

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
//    	for(int i = 0; i < board.length; i++) {
//    		for(int j = 0; j < board.length; j++) {
//    			board[i][j] = ' ';
//    			System.out.print(' ' + board[i][j] + ' ');
//    			if (j != board.length - 1) {
//    	           System.out.print('|');   
//    	        }
//        	}
//    		System.out.println();
//    		if(i != board.length - 1) {
//    			System.out.println("-----------");
//    		}
//    	}
    	
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board.length; j++) {
    			board[i][j] = ' ';
        	}
    	}
    }

    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
        /*
         * TBD
         */
    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() 
    {
    	String bb="";
    	for(int j = 0; j < 3; j++) 
    	{
    		
    		for(int i = 0; i < 3; i++) 
    		{
    			
    			bb +=" " + String.valueOf(board[i][j]) + " ";
    			if ( i != 2) 
    			{
     	           bb=bb +("|"); 
    	        }
    		
    		}
    		if( j !=2){
    			bb += "\n----------- \n" ;
    		}
    		
        }

		return bb;
       
    }

    /**
     * Get the entry of the board at column i, row j.  Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
		return 0;
        /*
         * TBD
         */
    }
    
    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
		return false;
        /*
         * TBD
         */
    }
}
