
/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she 
would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using
the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 
3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by 
calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: Yes, all of the above has been referenced, created, initialised and called, concluding with a check to see 
if anyone has won. (35/35)

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: Yes, all 7 methods have been defined in this interface. (10/10)

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method 
to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether 
the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides 
as implementation of the method to check whether there is a win.
Comment: Yes, the class implements the interface, and creates and provides everything mentioned above. (25/25)

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: Yes, setSymbol is abstract whereas getSymbol is not. (10/10)

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: Yes the abstract method is overwritten in this class. (10/10)

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: Yes the abstract method is overwritten in this class. (10/10)

Total Marks out of 100: 100

*/
import java.util.Random;
import java.util.Scanner;

public class Connect4Game {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean gameFinished = false;
		int gameType = 0;
		System.out.println("Welcome to Connect4!");
		do {
			System.out.println("Type 1 for Singleplayer. Type 2 for Multiplayer.");
			if (input.hasNextInt()) {
				gameType = input.nextInt();
			}
		} while (gameType != 1 && gameType != 2);
		Connect4Grid2DArray grid = new Connect4Grid2DArray();
		System.out.println(grid);
		C4HumanPlayer player1 = new C4HumanPlayer();
		player1.setSymbol('R');
		ConnectPlayer player2;
		if (gameType == 1) {
			player2 = new C4RandomAIPlayer();
			player2.setSymbol('Y');
		} else {
			player2 = new C4HumanPlayer();
			player2.setSymbol('Y');
		}
		boolean gotCol = false;
		do {
			do {
				gotCol = false;
				System.out.println("\nPlayer 1 " + player1.getSymbol() + " turn: (Type a number between 0 and 6)");
				if (input.hasNextInt()) {
					int col = input.nextInt();
					if (!grid.isValidColumn(col)) {
						System.out.println("Column must be between 0 and " + (grid.getTotalColumns() - 1));
						gotCol = false;
					} else if (grid.isColumnFull(col)) {
						System.out.println("Column " + col + " is full.");
						gotCol = false;
					} else {
						grid.dropPiece(player1, col);
						gotCol = true;
					}
				} else {
					input.next();
				}
			} while (!gotCol);
			System.out.println(grid);
			if (grid.didLastPieceConnect4()) {
				System.out.println("Player 1 wins!");
				gameFinished = true;
			} else {
				gotCol = false;
				do {
					int col;
					System.out.println("\nPlayer 2 " + player2.getSymbol() + " turn: (Type a number between 0 and 6)");
					if (gameType == 2) {
						col = input.nextInt();
					} else {
						Random rand = new Random();
						col = rand.nextInt(grid.getTotalColumns());
					}
					if (!grid.isValidColumn(col)) {
						System.out.println("Column must be between 0 and " + (grid.getTotalColumns() - 1));
						gotCol = false;
					} else if (grid.isColumnFull(col)) {
						System.out.println("Column " + col + " is full.");
						gotCol = false;
					} else {
						grid.dropPiece(player2, col);
						gotCol = true;
					}
				} while (!gotCol);
				System.out.println(grid);
				if (grid.didLastPieceConnect4()) {
					System.out.println("Player 2 wins!");
					gameFinished = true;
				}
			}
		} while (!grid.isGridFull() && !gameFinished);
		if (!gameFinished) {
			System.out.println("It's a Draw:");
		}
		input.close();
	}
}