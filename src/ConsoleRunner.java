/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author Nicholas Morgan (#201335841) & Matthew King
 */

import java.util.Scanner;

public class ConsoleRunner {

    /*
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX; //value to check if the player is X

    private boolean isChallenging; //value to check player is choosing a challenging opponent  
    
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
    	
    	boolean value = false;
    	
    	boolean error = false;
    	
    	do {
    		
    		error = false;
    		
    		System.out.println("Would you like to play as X? [Y/N]");
        	
        	String answer = scanner.next();
        	
        	if((answer.indexOf("Y") != -1 || answer.equalsIgnoreCase("Y")) && answer.length() == 1) {
        		
        		value = true;
        		this.playerIsX = value;
        		
        	} else if ((answer.indexOf("N") != -1 || answer.equalsIgnoreCase("N")) && answer.length() == 1) {
        		
        		value = false;
        		
        		this.playerIsX = value;
        		
        	} else {
        		
        		error = true;
        		
        	}
        	
        	if(error) {
        		
        		System.out.println("**Please try again**");
        		
        	}
        	
    	} while (error);
    	
    	do {
    		
    		error = false;
    		
    		System.out.println("Do you want a challenging Opponent? [Y/N]");
        	
        	String answer = scanner.next();
        	
        	if((answer.indexOf("Y") != -1 || answer.equalsIgnoreCase("Y")) && answer.length() == 1) {
        		
        		value = true;
        		
        		this.isChallenging = value;
        		
        	} else if ((answer.indexOf("N") != -1 || answer.equalsIgnoreCase("N")) && answer.length() == 1) {
        		
        		value = false;
        		
        		this.isChallenging = value;
        		
        	} else {
        		
        		error = true;
        		
        	}
        	
        	if(error) {
        		
        		System.out.println("**Please try again**");
        		
        	}
        	
    	} while (error);
    	
    	System.out.println(playerIsX);
    	
    	System.out.println(isChallenging);
        
        game=new Game(playerIsX, isChallenging);
    	
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
    		
    		boolean error = false;
    		
    		System.out.println(game.getBoard().toString());
    		
    		do {
    			
    			do {
    				
        			error = false;
        			
        			try {
        				
        				System.out.println("Choose a column [0:2]");
        				
            			scanner.nextLine();
            			
            			i = scanner.nextInt();
            			
        			} catch(Exception InputMismatchException) {
        				
        				error = true;
        				
        				System.out.println("Please enter an integer value between zero and two.");
        				
        			}
        			
        			if(i >= 3) {
        				
        				System.out.println("**Please try again with a number less than 3**");
        				
        				error = true;
        				
        			}
        			
        		} while(error);
        		
        		do {
        			
        			error = false;
        			
        			try {
        				
        				System.out.println("Choose a row [0:2]");
        				
    	    			scanner.nextLine();
    	    			
    	    			j = scanner.nextInt();
    	    			
        			} catch(Exception InputMismatchException) {
        				
        				error = true;
        				
        				System.out.println("Please enter an integer value between zero and two.");
        			}
        			
        			if(j >= 3) {
        				
        				System.out.println("**Please try again with a number less than 3**");
        				
        				error = true;
        			}
        			
        		} while(error);
        		
    		}while(!game.placePlayerPiece(i , j));
			
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
