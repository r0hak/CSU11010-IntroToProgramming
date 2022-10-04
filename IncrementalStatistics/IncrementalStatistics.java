/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:  5 
       Comment: Yes e.g. average
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: Yes e.g. previousAverage
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: Code has been indented appropriately
   4. Did I implement a while loop or do-while loop as required?
       Mark out of 10: 10  
       Comment: Yes a do-while loop can be seen below
      Total Mark out of  25 (Add all the previous marks): 25 
*/

import java.util.Scanner;

public class IncrementalStatistics {

	public static void main(String[] args) {
		int numbersEntered = 1;
		double average = 0;
		double variance = 0;
		boolean exit = false;
		
		
		System.out.println("This program computes the average and variance of all numbers entered.");
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Enter a number (or type 'exit'): ");
			if (sc.hasNext("exit")) {
				exit = true;	
			}
			else if (sc.hasNextDouble())
			{
				double number = sc.nextDouble();
				double previousAverage = average;
				double previousVariance = variance;
				average = previousAverage + ((number - previousAverage)/numbersEntered); 
				variance = ((previousVariance * (numbersEntered-1)) + ((number - previousAverage) * (number - average)))/numbersEntered;
				++numbersEntered;
				System.out.printf("So far the average is %.1f and the variance is %.1f\n", average, variance );	
			} 
			else {
				System.out.println("Error:  You must enter a real number (e.g. 12.5)");
				sc.next();
			}
		} while (!exit);
		System.out.print("Goodbye.");
		sc.close();
	}
	
}