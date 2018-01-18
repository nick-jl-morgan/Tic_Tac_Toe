/**
 * Contains the main method. Creates a ConsoleRunner and then calls its
 * mainLoop method.
 *
 * @author Nicholas Morgan (#201335841) & Matthew King (#201524766)
 */

public class TicTacToeApplication {

    public static void main(String[] args) {
    	
      ConsoleRunner Console = new ConsoleRunner(); //creates a new console for the game
      
      Console.mainLoop(); //calls the main loop to start the game
      
    }
}
