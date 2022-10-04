import java.util.Scanner;

public class TriangleArea {

	public static void main(String[] args) {
		
		System.out.print("Enter coordinates of triangle with spaces ");
		Scanner inputScanner = new Scanner( System.in );
		double x1 = inputScanner.nextDouble();
		double y1 = inputScanner.nextDouble();
		double x2 = inputScanner.nextDouble();
		double y2 = inputScanner.nextDouble();
		double x3 = inputScanner.nextDouble();
		double y3 = inputScanner.nextDouble();
		inputScanner.close();
		
		double area = Math.abs( (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) / 2.0 );
		
		System.out.print("The area of the triangle is " + area);
	}

}
