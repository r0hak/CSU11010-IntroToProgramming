import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class GradeComputation {

	 public static final String[] MODULE_CODES   = { "CSU11001", "CSU11010", 
	 			"CSU11013", "CSU11021", "CSU11022", "CSU11026", "CSU11031", 
	 			"CSU11081", "CSU12002", "STU11002" };
	 public static final int[] MODULE_CREDITS = { 5, 10, 5, 5, 5, 10, 5, 5, 5, 5 };
	 public static final double MIN_MARK=0.0;
	 public static final double MAX_MARK=100.0;
	 public static final int MIN_PERCENTAGE = 40;
	 public static final double TOTAL_CREDITS = 60.0;
	 public static final int FAIL_ALLOWED_CREDIT = 10;
	 public static final double FAIL_PERCENT = 35.0;

	 public static void main(String[] args) {
		boolean quit = false;
	
		System.out.println("Welcome to the first year grade assessor. ");
		double[] studentGrades = new double[10];
		
		Scanner input = new Scanner(System.in);
		
		do {
			int i =0;
			do {
				System.out.printf("Enter the student mark for %s (or enter quit): ", MODULE_CODES[i]);
				if (input.hasNext("quit")) {
					quit = true;
				}
				else if (input.hasNextDouble())
				{
					double grade = input.nextDouble();
					if (grade >= MIN_MARK && grade <= MAX_MARK) {
						studentGrades[i] = grade;
						++i;
					}
					else {
						System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
						input.next();
					}
				}
				else {
					System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
					input.next();
				}
			
			} while (!quit && i < 10);
			if (i == 10) {
				String strGrade = resultGrade(studentGrades);
				System.out.println(strGrade);
			}
		} while (!quit);
		input.close();
	}
	
	public static boolean checkFailStatus (double[] marks, int creditsBelowSpecifiedMark, double totalWeightedAverage)
	{
		boolean fail = false;
		if (creditsBelowSpecifiedMark > FAIL_ALLOWED_CREDIT || totalWeightedAverage < MIN_PERCENTAGE) {
			fail = true;
		}
		else {
			
			int i = 0;
			while (i< marks.length && !false) {
				if (marks[i] < FAIL_PERCENT) {
					fail = true;
				}
				++i;
			}
		}
		return fail;
		
	}
	
	public static int creditsBelowSpecifiedMark( double[] marks, int specifiedMinimumMark )
	{
		int i = 0;
		int totalCreditsbelowSpecifiedMark = 0;
		while (i < marks.length) {
			if (Math.round(marks[i]) < specifiedMinimumMark) {
				totalCreditsbelowSpecifiedMark = totalCreditsbelowSpecifiedMark + MODULE_CREDITS[i];
			}
			++i;
		}
		return totalCreditsbelowSpecifiedMark;
		
	}
	
	public static double weightedAverageMark( double[] marks )
	{
		int i = 0;
		double averageMark = 0.0;
		while (i < marks.length) {
			//double average = marks[i] * MODULE_CREDITS[i]/TOTAL_CREDITS;
			//averageMark = averageMark + average;
			averageMark = averageMark + ((marks[i] * MODULE_CREDITS[i])/TOTAL_CREDITS);
			//BigDecimal bd = new BigDecimal(Double.toString(averageMark));
		    //bd = bd.setScale(1, RoundingMode.HALF_UP);
		    //averageMark =  bd.doubleValue();
			//averageMark = averageMark + average; 
			++i;
		}
		return (double) Math.round(averageMark);
			
	}
	
	public static String gradeDetermination( double averagePercentage )
	{
		String strGrade = "";
		if (averagePercentage >= 70 )
		{
			strGrade = "I";
		} 
		else if (averagePercentage < 70 && averagePercentage >= 60)
		{
			strGrade = "II.1";
		}
		else if (averagePercentage < 60 && averagePercentage >= 50)
		{
			strGrade = "II.2";
		}
		else if (averagePercentage < 50 && averagePercentage >= 40)
		{
			strGrade = "III";
		}
		return strGrade;
	}	

	public static String determineOverallGrade( double[] marks )
	{
		int totalCreditsbelowSpecifiedMark = creditsBelowSpecifiedMark(marks, MIN_PERCENTAGE);
		double averageMark = weightedAverageMark (marks);
		boolean fail = checkFailStatus(marks, totalCreditsbelowSpecifiedMark, averageMark);
		String strGrade = "";
		
		
		if (fail)
		{
			strGrade = "FAIL";
		}
		else {
			strGrade = gradeDetermination(averageMark);	
		}
		return strGrade;
	}
	
	public static String resultGrade(double[] marks)
	{
		int totalCreditsbelowSpecifiedMark = creditsBelowSpecifiedMark(marks, MIN_PERCENTAGE);
		double averageMark = weightedAverageMark (marks);
		boolean fail = checkFailStatus(marks, totalCreditsbelowSpecifiedMark, averageMark);
		String strOverallGrade = "";
		String strAverageMark = String.format("%.0f", averageMark);
		String strGrade = determineOverallGrade(marks);
		
		if (fail)
		{	
			strOverallGrade =  "Result = " + strGrade + " with an overall mark of " + strAverageMark + "%.\n" +  totalCreditsbelowSpecifiedMark +  " credits were failed.\n\n";
		}
		else {
			strOverallGrade =  "Result = " + strGrade + " with an overall mark of " + strAverageMark + "%.\n\n";
		}
		return strOverallGrade;
	}
		
}
