/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10 
       Comment: All the variables have clear names that are easy to understand
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: As shown below, all variables are in lowerCamelCase
   3. Did I indent the code appropriately?
       Mark out of 15:   15
       Comment: Code has been indented appropriately
      Total Mark out of  30 (Add all the previous marks):  30
*/

import java.util.Scanner;

public class PlantClassifier {

	public static void main(String[] args) {
		System.out.print("Does the plant have cells and tissues which are organised into functional structures (Yes/No)? ");
		Scanner input = new Scanner( System.in );
		String functionalStructuresAnswer = input.next();
		boolean functionalStructure = functionalStructuresAnswer.equalsIgnoreCase("Yes");
		if (!functionalStructure)
		{
			System.out.println("The plant is an ALGAE.");
		}
		else
		{
			System.out.print("Does the plant have vascular tissues (Yes/No)? ");
			String vascularTissuesAnswer = input.next();
			boolean vascularTissues = vascularTissuesAnswer.equalsIgnoreCase("Yes");
			if (!vascularTissues)
			{
				System.out.println("The plant is a BRYOPHYTE.");
			}
			else
			{	
				System.out.print("Is the plant dispersed by seeds (Yes/No)? ");
				String seedDispersedAnswer = input.next();
				boolean seedDispersed = seedDispersedAnswer.equalsIgnoreCase("Yes");
				if (!seedDispersed)
				{
					System.out.println("The plant is a PTERIDOPHYTE.");
				}
				else
				{
					System.out.print("Are the seeds enclosed (Yes/No)? ");
					String seedEnclosedAnswer = input.next();
					boolean seedEnclosed = seedEnclosedAnswer.equalsIgnoreCase("Yes");
					if (!seedEnclosed)
					{
						System.out.println("The plant is a GYMNOSPERM.");
					}
					else
					{
						System.out.println("The plant is an ANGIOSPERM.");
					}
				}
				
			}
		}
		input.close();
	}
}
