/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment: Yes, ResolveBet does all the above mentioned things.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment: After inputting the amount in the wallet, the user is asked how much they wish to bet
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment: Yes, bet must be less than or equal to myWallet.check()
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment: Three die are rolled in an array, with the sum being stored in the variable total
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment: Yes, it's what's in the if statement to determine whether the user has won or not
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10].
Comment: Yes, a message containing either "You win!" or "You Lose!" is outputted followed by the amount in the wallet after the bet amount has been added or taken out.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment: Yes, this is the first thing that is asked of the user 
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment: Yes i have created a do while loop where the loop must continue until (!quit && (myWallet.check() > 0))
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment: Yes the user must enter one of Triple, Field, High or Low to continue with the bet
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment: Yes it does that: resolveBet(myBet, myWallet);
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment: Before the code terminates (because you either ran out of money or quit, you will be told how much was left in your wallet.

 Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class ChuckALuck {
	
	static Scanner sc;
	static void resolveBet(String sBetType, Wallet myWallet) 
	{
		
		boolean quit = false;
		do {
			System.out.print("Enter the amount you wish to bet (or enter quit): ");
			if (sc.hasNext("quit")) {
				quit = true;
			}
			else if (sc.hasNextDouble())
			{
				double bet = sc.nextDouble();
				if ( bet <= myWallet.check() && myWallet.check() > 0) {
					Dice [] diceArray = new Dice[3];
					int total = 0;
					boolean triple = false;
					for (int i =0; i < diceArray.length; ++i) {
						diceArray[i] = new Dice();
						diceArray[i].roll();
						System.out.printf("Dice[No.%d]: %d 		", i+1, diceArray[i].topFace());
						total = total + diceArray[i].topFace();
					}
					
					if ((diceArray[0].topFace() ==  diceArray[1].topFace()) && ( diceArray[1].topFace() == diceArray[2].topFace())) {
						triple = true;
					}
					switch (sBetType) 
					{	
						case "TRIPLE" :
							if (triple && diceArray[0].topFace() != 1 && diceArray[0].topFace() != 6 ) {
								System.out.println("\nYou win!");
								myWallet.put(bet*30);
							}
							else {
								System.out.println("\nYou lose!");
								myWallet.get(bet);
							}
							break;
						case "FIELD":
							if (total < 8 || total > 12) {
								System.out.println("\nYou win!");
								myWallet.put(bet);
							}
							else {
								System.out.println("\nYou lose!");
								myWallet.get(bet);
							}
							break;
						case "HIGH":
							if ((total < 11 ) || (triple && (diceArray[0].topFace() > 3))) {
								System.out.println("\nYou lose!");
								myWallet.get(bet);
							}
							else {
								System.out.println("\nYou win!");
								myWallet.put(bet);
							}
							break;
						case "LOW":
							if ((total > 11 ) || (triple && (diceArray[0].topFace() <= 3))) {
								System.out.println("\nYou lose!");
								myWallet.get(bet);
							}
							else {
								System.out.println("\nYou win!");
								myWallet.put(bet);
							}
							break;
						default:
							System.out.println("Invalid Bet!");
							break;
					}
					System.out.println(myWallet.toString());
					quit = true;
				}
				else {
					System.out.printf("Error - Number must greater than 0 and less than %.2f (or enter quit) \n", myWallet.check());
				}
			}
			else {
				System.out.printf("Error - Enter a number greater than 0 and less than %.2f (or enter quit) \n", myWallet.check());
				sc.next();
			}
		} while (!quit && (myWallet.check() > 0));
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		double walletAmount = 0;
		do {
			System.out.println("Welcome to ChuckALuck! ");
			System.out.println("Here are the Bet Types");
			System.out.println("Triple: All 3 dice show same numbers except 1s and 6s");
			System.out.println("Field: Total of 3 dice > 8 and < 12");
			System.out.println("High: Total of 3 dice > 10 (but not a Triple)");
			System.out.println("Low: Total of 3 dice < 11 (but not a Triple)");
			System.out.print("Enter the amount in your wallet: ");
			if (sc.hasNextDouble()) {
				walletAmount = sc.nextDouble();
				if (walletAmount <= 0) {
					System.out.println("Please enter a valid amount.");
				}
			}
			else {
				System.out.println("Please enter a valid amount.");
				sc.next();
			}
		} while (walletAmount <= 0);
		Wallet myWallet = new Wallet();
		myWallet.put(walletAmount);
		boolean quit = false;
		
		do {
			System.out.print("Place your bet (Triple, Field, High or Low) or quit: ");
			if (sc.hasNext()) {
				String myBet = sc.next();
				if (myBet.equalsIgnoreCase("quit")) {
					quit = true;
				}
				else if (myBet.equalsIgnoreCase("Triple") || myBet.equalsIgnoreCase("Field") || myBet.equalsIgnoreCase("High") || myBet.equalsIgnoreCase("Low")) {
					resolveBet(myBet.toUpperCase(), myWallet);
				}
				else {
					System.out.println("Please enter valid bet or quit ");
					sc.next();
				}
			}
			
		} while (!quit && myWallet.check() > 0);
		if (quit) {
			System.out.println(myWallet.toString());
		}
		sc.close();
	}
}
