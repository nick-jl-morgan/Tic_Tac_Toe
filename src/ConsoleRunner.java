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
    	
    	String answer = scanner.next();
    	
    	boolean value = ((answer.indexOf("Y") != -1 || answer.equalsIgnoreCase("Y")) && answer.length() == 1) ? true: false; 
        
    	this.playerIsX = value;
        
        System.out.println("Do you want a challenging Opponent? [Y/N]");
        
        answer = scanner.next();
    	
        value = ((answer.indexOf("Y") != -1 || answer.equalsIgnoreCase("Y")) && answer.length() == 1) ? true: false; 
        
        this.isChallenging = value;
        
//    	if( scanner.next().equalsIgnoreCase("Y") )
//        {
//        	this.playerIsX=true;
//        }
//        else
//        {
//        	this.playerIsX=false;
//        }
//        	
//        System.out.println("Do you want a challenging Opponent? [Y/N]");
//        if( scanner.next().equalsIgnoreCase("Y") )
//        {
//        	this.isChallenging=true;
//        }
//        else
//        {
//        	this.isChallenging=false;
//        }
        
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
    	GameStatus Status = GameStatus.IN_PROGRESS;
    	while(this.game.getStatus()== GameStatus.IN_PROGRESS)
    	{
    		int i=-1;
    		int j=-1;
    		System.out.println(game.getBoard().toString());
			do
    		{
				try{
    			System.out.println("Choose a column [0:2]");
    			scanner.nextLine();
    			i = scanner.nextInt();
    			System.out.println("Choose a row [0:2]");
    			scanner.nextLine();
    			j = scanner.nextInt();
				} catch(Exception InputMismatchException)
				{
					System.out.println("Please enter an integer value between zero and two.");
				}
				
    		} while (!game.placePlayerPiece(i , j) );
			
			Status= game.getStatus();
			if(Status != GameStatus.IN_PROGRESS)
			{
				break;
			}
			
			game.aiPlacePiece();
			
			
			
    	}
    	
    	System.out.println(game.getBoard().toString());
    	
    	if(Status==GameStatus.X_WON)
    	{
    		System.out.println("X won!");
    	}
    	if(Status==GameStatus.O_WON)
    	{
    		System.out.println("O won!");
    	}
    	if(Status==GameStatus.DRAW)
    	{
    		System.out.println("Everybody loses!");
    	}
    }
}
