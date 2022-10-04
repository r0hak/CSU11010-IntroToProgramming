import java.util.Scanner;

public class TutorialAverages {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter First Number ");
		double first = sc.nextDouble();
		System.out.print("Enter Second Number ");
		double second = sc.nextDouble();
		System.out.print("Enter Third Number ");
		double third = sc.nextDouble();
		sc.close();
		
		double Average = (first + second + third) / 3.0;
		double variance = ((first-Average)*(first-Average) +
				   			(second-Average)*(second-Average) +
				   			(third-Average)*(third-Average)) / 3.0;
double standardDeviation = Math.sqrt( variance );
 
		System.out.println("The Average is " + Average);
		System.out.println
			("The Standard Deviation is " + standardDeviation);
	}

}
