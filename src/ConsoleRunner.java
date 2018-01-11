/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author INSERT YOUR NAME(S) HERE
 */

import java.util.Scanner;

public class ConsoleRunner {

    /*
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX;

    private boolean isChallenging;
    
    private Game game;
    
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Constructor
     */
    public ConsoleRunner() {    
        /*
         * TBD
         *
         * Use the 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */
    	System.out.println("Would you like to play as X? [Y/N]");
    	
        if( scanner.next().equalsIgnoreCase("Y") )
        {
        	this.playerIsX=true;
        }
        else
        {
        	this.playerIsX=false;
        }
        	
        System.out.println("Do you want a challenging Opponent? [Y/N]");
        if( scanner.next().equalsIgnoreCase("Y") )
        {
        	this.isChallenging=true;
        }
        else
        {
        	this.isChallenging=false;
        }
        
        
        game=new Game( playerIsX, isChallenging);
    	
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */
    public void mainLoop() {
        /*
         * TBD
         *
         * Use the 'nextInt' method of Scanner class to read user responses as
         * integers.
         *
         * There is enough work to do here that you may want to introduce
         * private methods (i.e. helper methods).
         */
    	while(this.game.getStatus()== GameStatus.IN_PROGRESS)
    	{
    		
    	//dostuff
    		
    	}
    }
}
