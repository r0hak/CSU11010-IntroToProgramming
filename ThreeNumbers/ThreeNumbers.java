/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:   5
       Comment: Yes, e.g. firstNumber
    2. Did I indent the code appropriately?
       Mark out of 5: 	5
       Comment: Yes Code has been indented appropriately
   3. Did I make use of the functions appropriately within main and the other functions?
       Mark out of 10:   10
       Comment: Yes I have made use of the functions appropriately.
       Total Mark out of  20 (Add all the previous marks): 20 
*/
import java.util.Scanner;

public class ThreeNumbers {

	public static void main(String[] args) {
		
		Scanner input = new Scanner( System.in );
		boolean quit = false;
		while (!quit){
		System.out.print("Please enter your three integers separated by spaces (or enter 'quit'): ");
		if (input.hasNext("quit")) {
		quit = true;
		}
		else {
		input.useDelimiter("(\\p{javaWhitespace})+");
		int firstNumber = input.nextInt();
		int secondNumber = input.nextInt();
		int thirdNumber = input.nextInt();
		int countOfGreaterThanAverage = countOfNumbersGreaterThanTheAverage(firstNumber, secondNumber, thirdNumber);
		int median = medianOf(firstNumber, secondNumber, thirdNumber);
		System.out.println(getFormattedOutputString(median, countOfGreaterThanAverage));
		}
					
		}
		input.close();
			
	}

	public static int medianOf( int firstNumber, int secondNumber, int thirdNumber ) 
	{
		if ((secondNumber > firstNumber && firstNumber > thirdNumber) || (thirdNumber > firstNumber && firstNumber > secondNumber) 
			|| (firstNumber == secondNumber) || (firstNumber == thirdNumber)) 
            return firstNumber; 
  
        else if ((firstNumber > secondNumber && secondNumber > thirdNumber) || (thirdNumber > secondNumber && secondNumber > firstNumber) 
        		|| (secondNumber == thirdNumber)) 
        return secondNumber; 
  
        else
        return thirdNumber;	
	}
	
	public static double averageOf( int firstNumber, int secondNumber, int thirdNumber )
	{
		double average = 0;
		average = ((double)firstNumber + (double)secondNumber + (double)thirdNumber) / 3.0;
		return average; 
	}
	
	public static int countOfNumbersGreaterThanTheAverage( int firstNumber, int secondNumber, int thirdNumber )
	{
		int count = 0;
		double average = averageOf ( firstNumber, secondNumber, thirdNumber);
		if ( firstNumber > average) count++;
		if ( secondNumber > average) count++;
		if ( thirdNumber > average) count++;
		return count;
			
	}
	public static String getFormattedOutputString( int median, int countOfGreaterThanAverage )
	{
		String sentence = "The median of your numbers is " + median + ", and " + countOfGreaterThanAverage;
		
		if (countOfGreaterThanAverage == 1 || countOfGreaterThanAverage == 0)
		{
			sentence = sentence + " of them is greater than their average.";	
		}
		else
		{
			sentence = sentence + " of them are greater than their average.";
		}
		return sentence;
	}
	
}


