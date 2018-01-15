/**
 * Represents the logic of the game in terms of detecting wins or draws.  Also
 * places new pieces for the human player or AI.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

public class Game {
    private Board board = new Board();
    private GameStatus status;
    private AI ai;
    private char playerChar;

    
    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        /*
         * TBD
         */
    	this.status=GameStatus.IN_PROGRESS;
    	if(challenging)
    	{
    		this.ai= new SmartAI(!playerIsX);
    	}
    	else
    	{
    		this.ai = new DumbAI(!playerIsX);
    	}
    	if(playerIsX)
    	{
    		this.playerChar='X';
    	}
    	else
    	{
    		this.playerChar='O';
    	}
    	
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        
    	return board;
    	
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
    	
    	//ATTENTION
    	
    	// There are 8 possible victories that must be checked, for both the player and the AI.
    
    	//if the board is full and neither player nor AI has won then status = DRAW
    	
    	if(board.get(0,0)=='X' && board.get(0, 1)=='X' && board.get(0, 2)=='X')
    	{
    		status=GameStatus.X_WON; //Won by left column.
    	}
    	
    	if(board.get(0,0)=='O' && board.get(0, 1)=='O' && board.get(0, 2)=='O')
    	{
    		status=GameStatus.O_WON; //Won by left column.
    	}
    	
    	if(board.get(1,0)=='X' && board.get(1, 1)=='X' && board.get(1, 2)=='X')
    	{
    		status=GameStatus.X_WON; //Won by Center column.
    	}
    	
    	if(board.get(1,0)=='O' && board.get(1, 1)=='O' && board.get(1, 2)=='O')
    	{
    		status=GameStatus.O_WON; //Won by Center column.
    	}
    	if(board.get(2,0)=='X' && board.get(2, 1)=='X' && board.get(2, 2)=='X')
    	{
    		status=GameStatus.X_WON; //Won by Left column.
    	}
    	
    	if(board.get(2,0)=='O' && board.get(2, 1)=='O' && board.get(2, 2)=='O')
    	{
    		status=GameStatus.O_WON; //Won by Left column.
    	}
    	
    	
    	
    	//Rows
    	
    	if(board.get(0,0)=='X' && board.get(1, 0)=='X' && board.get(2, 0)=='X')
    	{
    		status=GameStatus.X_WON; //Won by Top row.
    	}
    	
    	if(board.get(0,0)=='O' && board.get(1, 0)=='O' && board.get(2, 0)=='O')
    	{
    		status=GameStatus.O_WON; //Won by Top row.
    	}
    	
    	
    	if(board.get(0,1)=='X' && board.get(1, 1)=='X' && board.get(2, 1)=='X')
    	{
    		status=GameStatus.X_WON; //Won by Center row.
    	}
    	
    	
    	if(board.get(0,1)=='O' && board.get(1, 1)=='O' && board.get(2, 1)=='O')
    	{
    		status=GameStatus.O_WON; //Won by Center row.
    	}
    	
    	    	
    	if(board.get(0,2)=='X' && board.get(1, 2)=='X' && board.get(2, 2)=='X')
    	{
    		status=GameStatus.X_WON; //Won by Bottom row.
    	}
    	
    	if(board.get(0,2)=='O' && board.get(1, 2)=='O' && board.get(2, 2)=='O')
    	{
    		status=GameStatus.O_WON; //Won by Bottom row.
    	}
    	
    	
    	//Diagonals
    	
    	if(board.get(0,0)=='X' && board.get(1, 1)=='X' && board.get(2, 2)=='X')
    	{
    		status=GameStatus.X_WON; //Won by Left top - bottom right diagonal.
    	}
    	
    	if(board.get(0,0)=='O' && board.get(1, 1)=='O' && board.get(2, 2)=='O')
    	{
    		status=GameStatus.O_WON; //Won by Left top - bottom right diagonal.
    	}
    	
     	if(board.get(0,2)=='X' && board.get(1, 1)=='X' && board.get(2, 0)=='X')
    	{
    		status=GameStatus.X_WON; //Won by bottom left - top right diagonal
    	}
    	
    	if(board.get(0,2)=='O' && board.get(1, 1)=='O' && board.get(2, 0)=='O')
    	{
    		status=GameStatus.O_WON; //Won by bottom left - top right diagonal
    	}
    	
    	
    	//tie
    	
    	if(status==GameStatus.IN_PROGRESS && board.isFull())
    	{
    		status=GameStatus.DRAW;
    	}
    	
    	
    	return status; 
    	
    }
    
    /**
     * Place a piece for the player on the board.
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     * range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) 
    {
		if(i>2 || j>2 || i<0 || j<0)
		{
			return false; 
		} 
		if(board.get(i,j)==' ')
		{	
			Move move = new Move(i,j,playerChar);
			board = new Board(board, move);
			return true;
		}
		else
		{
			return false;
		}
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
       
    	Move move= ai.chooseMove(board);
    	board=new Board(board,move);
    }
}
