import java.util.Scanner;

public class LineTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean quit = false;
		int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
		Point p1, p2;
		do {
			System.out.println("Finding the slope of a line.");
			System.out.print("Type quit to quit the program or press enter to continue:");
			String searchTitle = sc.nextLine();
			if (searchTitle.equalsIgnoreCase("quit")) {
				quit = true;
		}
		else {
			boolean invalidCordinates = true;
			while (invalidCordinates) {
				System.out.print("Please enter the X coordinate for point 1 for the first line: ");
				x1 = sc.nextInt();
				System.out.print("Please enter the Y coordinate for point 1 for the first line: ");
				y1 = sc.nextInt();
				if (x1 < 0) {
					System.out.println("Invalid x cordrinate");
					invalidCordinates = true;
				}
				else {
					invalidCordinates = false;
				}
			}
			invalidCordinates = true;
			while (invalidCordinates) {
				System.out.print("Please enter the Y coordinate for point 1 for the first line: ");
				y1 = sc.nextInt();
				if (y1 < 0){
					System.out.println("Invalid y coordinate");
					invalidCordinates = true;
				}
				else {
					invalidCordinates = false;
				}
			}
			
			p1 = new Point(x1, y1);
			
			System.out.print("Please enter the X coordinate for point 2 for the first line: ");
			x2 = sc.nextInt();
			System.out.print("Please enter the Y coordinate for point 2 for the first line: ");
			y2 = sc.nextInt();
// i am going to show to show try catch exception for point p2 exception
			p2 = new Point(x2, y2);
			Line l1 = new Line(p1, p2);
			System.out.printf("X coordinates of Point 1 of the 1st Line: %d\n", l1.getP1().getX());
			System.out.printf("Y coordinates of Point 1 of the 1st Line: %d\n", l1.getP1().getY());
			System.out.printf("X coordinates of Point 2 of the 1st Line: %d\n", l1.getP2().getX());
			System.out.printf("Y coordinates of Point 2 of the 1st Line: %d\n", l1.getP2().getY());
			try {
				double slope1 = l1.getSlope();
				System.out.printf("The slope of Line 1 is: %.2f\n", slope1);
			}
			catch (Exception e) { 
				System.out.println("Slope not defined.");
			}
			System.out.print("Please enter the X coordinate for point 1 for the second line: ");
			x1 = sc.nextInt();
			System.out.print("Please enter the Y coordinate for point 1 for the second line: ");
			y1 = sc.nextInt();
			System.out.print("Please enter the X coordinate for point 2 for the second line: ");
			x2 = sc.nextInt();
			System.out.print("Please enter the Y coordinate for point 2 for the second line: ");
			y2 = sc.nextInt();
		
			Line l2 = new Line(x1, y1, x2, y2);
			System.out.printf("X coordinates of Point 1 of the 2nd Line: %d\n", l2.getP1().getX());
			System.out.printf("Y coordinates of Point 1 of the 2nd Line: %d\n", l2.getP1().getY());
			System.out.printf("X coordinates of Point 2 of the 2nd Line: %d\n", l2.getP2().getX());
			System.out.printf("Y coordinates of Point 2 of the 2nd Line: %d\n", l2.getP2().getY());
			try {
				double slope1 = l2.getSlope();
				System.out.printf("The slope of Line 1 is: %.2f\n", slope1);
				}
				catch (Exception e) { 
					System.out.println("Slope not defined.");
				}
			}
		} while (!quit);
		sc.close();
	}
}
