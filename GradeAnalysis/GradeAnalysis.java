import java.util.Scanner;

public class GradeAnalysis {

		public static final int NUMBER_OF_MARKS=5;
		public static final double MIN_MARK=0.0;
		public static final double MAX_MARK=100.0;
		
		public static double determineAverageMark( double[ ] marks )
		{
			if (marks == null)
				return 0.0;
			double totalMarks = 0;
			for (int index=0; index<marks.length; index++)
				totalMarks += marks[index];
			return totalMarks/marks.length;
		}
		
		public static int countAboveAverageStudents( double[ ] marks, double average )
		{
			if (marks == null)
				return 0;
			int aboveAverageCount = 0;
			for (int index=0; index<marks.length; index++)
				if (marks[index] > average)
					aboveAverageCount++;
			return aboveAverageCount;
		}

		public static void main(String[] args) {
			
			System.out.print("Enter the " + NUMBER_OF_MARKS + " percentages obtained: ");
			Scanner marksScanner = new Scanner( System.in );
			int marksCount = 0;
			double percentages[] = new double[NUMBER_OF_MARKS];
			while ((marksCount < NUMBER_OF_MARKS) && (marksScanner.hasNextDouble()))
			{
				double currentMark = marksScanner.nextDouble();
				if ((currentMark >= MIN_MARK) && (currentMark <= MAX_MARK) &&
						(marksCount <= NUMBER_OF_MARKS))
				{
					percentages[marksCount] = currentMark;
					marksCount++;
				}
			}
			if (marksCount != NUMBER_OF_MARKS)
			{
				System.out.println("Invalid marks entered.  " + NUMBER_OF_MARKS +
						"marks should be entered between " + MIN_MARK + " and " + MAX_MARK + ".");
			}
			else
			{
				double averageMark = determineAverageMark( percentages );
				int numberAboveAverage = countAboveAverageStudents( percentages, averageMark );
				System.out.println("The average percentage is " + averageMark + "% and there " +
				  ((numberAboveAverage > 1) ? "were " + numberAboveAverage + " above average students." :
				      ((numberAboveAverage == 1) ? "was only 1 above average student." :
				    	  "were no above average students.")));
			}
		}
		

	

}
