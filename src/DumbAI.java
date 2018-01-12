/**
 * Realization of AI interface using simplistic random placement strategy.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

import java.util.Random;

public class DumbAI implements AI {
    
    private Random random = new Random();
    private char aiChar;
    /*
     * TBD: Create additional private members if useful.
     */
    
    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) 
    {
        if (aiIsX)
        {
        	aiChar='X';
        }
        else
        {
        	aiChar='O';
        }
    }

    public Move chooseMove(Board board) 
    {	int i;
    	int j;
    	
    	do{
    	i=random.nextInt(3); //random in range [0,2] 
    	j=random.nextInt(3);
    	} while(board.get(i, j) !=  ' ');
    	
		return new Move(i,j,aiChar);
    }
}
