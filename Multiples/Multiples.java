import java.util.Scanner;

public class Multiples {

	public static void main(String[] args) {
		System.out.print("Enter your number: ");
		Scanner input = new Scanner ( System.in );
		int number = input.nextInt();
		System.out.print("Enter the limit: ");
		int limit = input.nextInt();
		input.close();
		
		if ((number > 0 ) && (limit > 0))
		{
			System.out.print("The multiples of " + number + " (up to " + limit + ") are ");
			for (int total = 0; (total < limit); total+=number)
				System.out.print(((total>0)?", ":"") + total);
			System.out.println("");
				
		}
	}

}
