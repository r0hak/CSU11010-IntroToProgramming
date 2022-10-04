/* SELF ASSESSMENT 
   1.    createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes correct method definition was used
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:Yes an array was created and initialised
Did I return the correct item?
Mark out of 5:5
Comment:Yes
   2.    crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes correct method definition was used
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:Yes
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:Yes
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:Yes as can be shown when the program is run
   3.    sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes
Did I make calls to other methods?
Mark out of 5:5
Comment:Yes     
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment:Yes
   4.    sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10 
Comment: Yes   
   5.    nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:Yes    
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:Yes
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:Yes
   6.    main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments:Yes
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:Yes, sieve
Did I print the output as shown in the question?  
Mark out of 5:5
Comment:Yes
   7.    Overall
Is my code indented correctly?
Mark out of 4:4
Comments:Yes
Do my variable names make sense?
Mark out of 4:4
Comments:They do
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:Yes
      Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class SieveOfEratosthenes {
	
	
	public int primeNumber;
	
	public int[] createSequence(int upperLimit)
    {
        
		int[] anArray = new int[upperLimit-1];
        for (int i = 0; i <= upperLimit; i++) {
        	if (i > 1 ) {
        		anArray[i-2] = i;
        		if (anArray.length == i - 1) {
        		System.out.print(anArray[i-2] + " ");
        		}
        		else {
        			System.out.print(anArray[i-2] + ", ");
        		}
        	}
        }
        System.out.println();
        return anArray;
 
        
    }
	
	public int[] crossOutHigherMultiples(int[] anArray, int num)
	{
		
		int iArrayLength = anArray.length;
		int iNum = (iArrayLength /num) + (iArrayLength > 0 ? 1 : 0);
		int iTempCrossOutSeq[] = anArray.clone();
		int iTempCount = 0;
		
		for (iTempCount = 2; iTempCount <= iNum; iTempCount++ ) {
			if (((iTempCount*num)-2) < iArrayLength ) iTempCrossOutSeq[(iTempCount*num)-2] = 0;
		}
		return iTempCrossOutSeq;
		
	}
	
	void sieve(int upperLimit)
	{
		int [] anIntSeq = new int[upperLimit];
	    int [] anCrossoutSeq = new int[upperLimit];
	    anIntSeq = createSequence(upperLimit);
	    anCrossoutSeq = anIntSeq.clone();
	    int i = 2;
	    int iNextPrime = 0;
	    
	    while ( i <= upperLimit) {
	    	if (i <= 3) {
	    		anCrossoutSeq = crossOutHigherMultiples(anCrossoutSeq, i);
	    		sequenceToString(anCrossoutSeq);
	    		System.out.println();
	    		setPrimeNumber(i);
	    		++i;
	    	}
	    	else {
	    		int currentPrimeNumber = primeNumber;
	    		iNextPrime = getNextPrimeNumber(anCrossoutSeq,i);
	    		anCrossoutSeq = crossOutHigherMultiples(anCrossoutSeq, iNextPrime);
	    		sequenceToString(anCrossoutSeq);
	    		System.out.println();
	    		i = iNextPrime+1;
	    		if (i == upperLimit) break;
	    		if (currentPrimeNumber == iNextPrime) break;
	    	}
	    	
	    }
	    nonCrossedOutSubseqToString(anCrossoutSeq);
        
	}
	
	void sequenceToString(int [] anArray)
	{
		System.out.print("");
		for (int i = 0; i < anArray.length; ++i) {
			int iValue = anArray[i];
			if (iValue != 0) {
				if (anArray.length == iValue - 1) {
	        		System.out.print(iValue + " ");
	        		}
	        		else {
	        			System.out.print(iValue + ", ");
	        		}
				
			}
			else {
				iValue = i + 2;
				if (anArray.length == iValue - 1) {
	        		System.out.print("[" + iValue +"]");
	        		}
	        		else {
	        			System.out.print("[" + iValue +"], ");
	        		}
			}
		}
	}
	
	void nonCrossedOutSubseqToString(int [] anArray)
	{
		System.out.print("");
		for (int i = 0; i < anArray.length; ++i) {
			int iValue = anArray[i];
			if (iValue != 0) {
				if (primeNumber == iValue) {
	        		System.out.print(iValue + " ");
	        		}
	        		else {
	        			System.out.print(iValue + ", ");
	        		}
			}
		}
		
	}
	
	int getNextPrimeNumber (int [] anArray, int start) {
		int i = start-2;
		while (i < anArray.length) {
			if (anArray[i] != 0)  {
				primeNumber = anArray[i];
				break;
			}
			++i;
		}
		return primeNumber;
		
	}
	
	void setPrimeNumber( int number)
	{
		primeNumber = number;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter int >= 2: ");
		if (sc.hasNextInt()) {
			int upperLimit = sc.nextInt();
			if (upperLimit >= 2) {
				SieveOfEratosthenes g = new SieveOfEratosthenes();
				g.sieve(upperLimit);
			}
			else {
				  System.out.println("Input was not a number >= 2. Program terminated.");
				}
			}
		else {
			System.out.println("Input was not a number >= 2. Program terminated.");
		}
	    sc.close();
	}

}
