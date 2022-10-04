/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:  5 
       Comment: place is very simple to understand
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:  5 
       Comment: the variable place is in lowerCamelCase
   3. Did I indent the code appropriately?
       Mark out of 5: 5  
       Comment: Code has been indented properly
   4. Did I implement a switch statement as required?
       Mark out of 10:  10 
       Comment: There is a switch statement within the do-while loop
       Total Mark out of  25 (Add all the previous marks):  25
*/

import java.util.Scanner;

public class Prizes {

	public static void main(String[] args) {
		boolean exit = false;
		int place = 0;
		
		System.out.println("This program tells competition participants what prize they have won.");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Enter your place number (or type 'exit'): ");
			if (sc.hasNext("exit")) {
				exit = true;
			}
			else if (sc.hasNextInt())
			{
				place = sc.nextInt();
				switch (place)
				{ 
				case 1: 
					System.out.println("You came in 1st place and hence won "
									+ "two theatre tickets + drinks during "
									+ "the interval + dinner before the show.");
					break;
				case 2: 
					System.out.println("You came in 2nd place and hence won two theatre tickets"
									+ " + drinks during the interval.");
					break;
				case 3:
					System.out.println("You came in 3rd place and hence won two theatre tickets.");
					break;
				case 4:
				case 5:
					System.out.println("You came in " + place + "th place and hence won a 10 Euro book token.");
					break;
				case 6: 
				case 7:
				case 8:
				case 9:
				case 10:
					System.out.println("You came in " + place + "th place and hence won a 5 Euro book token.");
					break;
				default:
					System.out.println("Sorry.  You did not win a prize.");
				}
			}
			else {
				System.out.println("Sorry.  You did not win a prize.");
				sc.next();
			}
		} while (!exit);
		sc.close();
	}
}

