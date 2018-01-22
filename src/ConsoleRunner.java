/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 *
 * @author Nicholas Morgan (#201335841) & Matthew King (#201524766)
 */

import java.util.Scanner;

public class ConsoleRunner {

    /*
     * Should the human player be the X?  Note that X always
     * goes first.
     */
    private boolean playerIsX; //value to check if the player is X

    private boolean isChallenging; //value to check player is choosing a challenging opponent  
    
    private Game game; //value for game state
    
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
    		
    		System.out.println("Would you like to play as X? [Y/N]"); //asks the player if they want to play X or O
        	
        	String answer = scanner.next(); //scans for a keyboard response
        	
        	if((answer.indexOf("Y") != -1 || answer.equalsIgnoreCase("Y")) && answer.length() == 1) { //checks if the users input was a capital y or lower case, it also checks if the response is one character long
        		
        		value = true;
        		
        		this.playerIsX = value;
        		
        	} else if ((answer.indexOf("N") != -1 || answer.equalsIgnoreCase("N")) && answer.length() == 1) { //checks if the users input was a capital n or lower case, it also checks if the response is one character long
        		
        		value = false;
        		
        		this.playerIsX = value;
        		
        	} else { //if the response from the user was not the required value the error variable will be set to true
        		
        		error = true;
        		
        	}
        	
        	if(error) {
        		
        		System.out.println("**Please try again**"); //outputs a error message to the user
        		
        	}
        	
    	} while (error); //checks if error is false if it is true it will performing the previous do statement
    	
    	do {
    		
    		error = false;
    		
    		System.out.println("Do you want a challenging Opponent? [Y/N]"); //outputs the question if the user wants a challenging AI
        	
        	String answer = scanner.next();
        	
        	if((answer.indexOf("Y") != -1 || answer.equalsIgnoreCase("Y")) && answer.length() == 1) { //checks if the users input was a capital y or lower case, it also checks if the response is one character long
        		
        		value = true;
        		
        		this.isChallenging = value;
        		
        	} else if ((answer.indexOf("N") != -1 || answer.equalsIgnoreCase("N")) && answer.length() == 1) { //checks if the users input was a capital n or lower case, it also checks if the response is one character long
        		
        		value = false;
        		
        		this.isChallenging = value;
        		
        	} else { //if the response from the user was not the required value the error variable will be set to true
        		
        		error = true;
        		
        	}
        	
        	if(error) {
        		
        		System.out.println("**Please try again**");
        		
        	}
        	
    	} while (error);
        
        game=new Game(playerIsX, isChallenging); //calls the constructor Game and passes the user response to both questions
    	
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
    	GameStatus Status = GameStatus.IN_PROGRESS; //sets the status of the game to in progress 
    	
    	while(this.game.getStatus()== GameStatus.IN_PROGRESS) //loop for the game that will end until status is not in progress
    	{
    		
    		int i=-1;
    		
    		int j=-1;
    		
    		boolean error = false; //variable to check for a error 
    		
    		System.out.println(game.getBoard().toString()); //prints the board state
    		
    		do {
    			
    			do {
    				
        			error = false;
        			
        			try { //try and catch statement for the column value from the user
        				
        				System.out.println("Choose a column [0:2]");
        				
            			scanner.nextLine();
            			
            			i = scanner.nextInt();
            			
        			} catch(Exception InputMismatchException) {
        				
        				error = true;
        				
        				System.out.println("Please enter an integer value between zero and two.");
        				
        			}
        			
        			if(i >= 3 || i < 0) { //checks if the value is between 0-2
        				
        				System.out.println("**Please try again with a number between 0 and 2**");
        				
        				error = true;
        				
        			}
        			
        		} while(error);
        		
        		do {
        			
        			error = false;
        			
        			try { //try and catch statement for the row value from the user
        				
        				System.out.println("Choose a row [0:2]");
        				
    	    			scanner.nextLine();
    	    			
    	    			j = scanner.nextInt();
    	    			
        			} catch(Exception InputMismatchException) {
        				
        				error = true;
        				
        				System.out.println("Please enter an integer value between zero and two.");
        			}
        			
        			if(j >= 3 || j <0 ) { //checks if the value is between 0-2
        				
        				System.out.println("**Please try again with a number between 0 and 2**");
        				
        				error = true;
        			}
        			
        		} while(error);
        		
    		}while(!game.placePlayerPiece(i , j)); //checks if the player can place a move
			
			Status= game.getStatus(); //checks the status of the game
			
			if(Status != GameStatus.IN_PROGRESS) //checks if the game is still in progress 
			{
				break;
			}
			
			game.aiPlacePiece(); //makes a call for the AI to make a move 
			
    	}
    	
    	System.out.println(game.getBoard().toString()); //prints out board state
    	
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
