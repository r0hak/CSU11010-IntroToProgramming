import java.util.Scanner;

public class MyBMI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	      System.out.print("Input weight in Kg: ");
	      double weight = sc.nextDouble();
	      System.out.print("Input height in metres: ");
	      double height = sc.nextDouble();
	      double BMI = weight / (height * height);
	      System.out.print("Your BMI is " + BMI);

	}

}
