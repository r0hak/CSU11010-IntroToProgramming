/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:   5 
       Comment: final double on the 25th line indicates that I have
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:   5
       Comment: MONTHS_PER_YEAR is very straightforward
        3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:   5
       Comment: They are in all caps
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:   10
       Comment: All the variable names are easy-to-understand
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: Yes, e.g. monthlyTerm
   6. Did I indent the code appropriately?
       Mark out of 10:  10 
       Comment: Indentation has been done below
     Total Mark out of  40 (Add all the previous marks):  40
*/
import java.util.Scanner;

public class LoanRepaymentCalculator {
	public static final double MONTHS_PER_YEAR = 12;

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Enter loan amount? ");
		double principal = sc.nextDouble();
		System.out.print("Enter annual interest rate (e.g. 0.04)? ");
		double interest = sc.nextDouble();
		System.out.print("Enter the term of the loan in years? ");
		double term = sc.nextDouble();
		sc.close();	
		
		double repayment = principal * (((interest / MONTHS_PER_YEAR) * 
			               (Math.pow((1+(interest / MONTHS_PER_YEAR)), (term * MONTHS_PER_YEAR)))) /
						   (Math.pow((1+(interest / MONTHS_PER_YEAR)), (term * MONTHS_PER_YEAR)) - 1));
		
		
		System.out.printf("The monthly repayment for a %.0f year loan of %.2f "
						  + "at an annual interest rate of %.2f would be %.2f" , 
						  term, principal, interest, repayment);
			

				
		

	}

}
