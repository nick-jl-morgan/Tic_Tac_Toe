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

    /*
     * TBD: Create additional private members if useful.
     */

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
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        /*
         * TBD
         */
    	return board;
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
        /*
         * TBD
         */
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
    public boolean placePlayerPiece(int i, int j) {
		return false;
        /*
         * TBD
         */
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        /*
         * TBD
         */
    }
}
