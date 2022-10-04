/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable and constant names?
       Mark out of 10:  10 
       Comment: Yes I have done so, e.g. MAX_NO_OF_INTEGERS and average
   2. Did I format the variable and constant names properly (in lowerCamelCase and UPPERCASE)?
       Mark out of 5:  5 
       Comment: Yes I have done so, e.g. MAX_NO_OF_INTEGERS and average
   3. Did I indent the code appropriately?
       Mark out of 10:   
       Comment: Yes the code has been indented properly
   4. Did I implement a for loop to read the input as required?
       Mark out of 10:   10
       Comment: The for loop is visible from line 34
      Total Mark out of  35 (Add all the previous marks):  35
*/
import java.util.Scanner;

public class TotalAverageCalculator {
	
	public static final int MAX_NO_OF_INTEGERS = 10;
	public static final int MIN_NO_OF_INTEGERS = 2;	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double sum = 0;
		double average = 0;
		
		System.out.print("How many integers do you want to enter? ");
		int integers = sc.nextInt();
		
		if (integers >= MIN_NO_OF_INTEGERS && integers <= MAX_NO_OF_INTEGERS)
		{
			for (int number = 1; number <= integers; number++)
			{
				System.out.print("Enter integer " + number + ": ");
				double digit = sc.nextDouble();
			
				sum += digit;
			
			}
				average = sum / (double)integers;
				
				System.out.printf("The sum of your integers is %.0f and the average is %.2f " , sum, average);
				
		}
		else 
		{
			System.out.println("Error:  This program is constrained to only compute the total & average of between 2 & 10 integers. ");
		}
		sc.close();
		

	}

}
