/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5: 5  
       Comment: Yes e.g. maxNumber
    2. Is my code easy to follow/understand?
       Mark out of 5:   5
       Comment: Code is easy to follow
   3. Did I use the functions as required?
       Mark out of 10:   10
       Comment: all functions have been used as required
       Total Mark out of  20 (Add all the previous marks):  20
*/

import java.util.Scanner;

public class PerniciousNumbers {

	public static void main(String[] args) {
	    int count = 1;
	    Scanner input = new Scanner( System.in );
	    
	    System.out.print("Enter the maximum number you want to consider: ");
	    if (input.hasNextInt()) {
	    	int maxNumber = input.nextInt();
	    	if (maxNumber > 0)
	    	{
	    		while (count <= maxNumber)
		    	{
		    		if (isPernicious(count))
		    		{
		    			String binaryString = getBinaryString(count);
		    			System.out.println(getFormattedOutputString(count, countBinaryOnes(count), binaryString));
		    		}
		    		count++;
		    	}
	    	}
	    	else
	    	{
	    		count = maxNumber;
	    		while (count < 0)
	    		{
	    			if (isPernicious(count))
		    		{
		    			String binaryString = getBinaryString(count);
		    			System.out.println(getFormattedOutputString(count, countBinaryOnes(count), binaryString));
		    		}
		    		count++;
	    		}
	    	}
	    	
	    }
	    else
	    {
	    	System.out.println("No integer entered.");
	    }
	    input.close();
	}
	
	public static String getBinaryString( int number )
	{
		String binaryString = "";
		if ( number < 0 ) {
			number = number * -1;
			binaryString = Integer.toBinaryString( number );
			binaryString = "-" + binaryString;
		}
		else {
		binaryString = Integer.toBinaryString( number );
		}
		return binaryString;
		
	}

	public static int countBinaryOnes( int number )
	{
		int count=0;
		if (number < 0)
		{
			number = number * -1;
		}
	    while (number!=0)
	    {
	        number = number & (number-1);
	        count++;
        }
        return count;
	}
	
	public static boolean isPrime( int number )
	{
		boolean isPrimeNumber = true;
		 
		if(number <= 1) 
		{
			isPrimeNumber = false;
			return isPrimeNumber;
		}
		else
		{
			for (int divisor = 2; divisor <= number/2; divisor++) 
			{
				if ((number % divisor) == 0)
				{
					isPrimeNumber = false;
					break;
				}
			}
		 return isPrimeNumber;
		}
	}
	
	public static boolean isPernicious( int number )
	{
		boolean pernicious = false;
		int total = countBinaryOnes(number);
		if ( isPrime(total))
		{
			pernicious = true;
		}
		return pernicious;	
	}
	
	public static String getFormattedOutputString( int currentNumber, int countBinaryOnes, String getBinaryString)
	{
		String sentence = "" + currentNumber + " is a pernicious number as it contains " + countBinaryOnes;
		if (countBinaryOnes == 1)
		{
			sentence = sentence + " one in it's binary representation (" + getBinaryString + ")";	
		}
		else
		{
			sentence = sentence + " ones in it's binary representation (" + getBinaryString + ")";
		}
		return sentence;
	}
}
