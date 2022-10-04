import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
		System.out.print("What is your weight in kg? ");
	    double weight = sc.nextDouble();
	    System.out.print("What is your height in metres? ");
	    double height = sc.nextDouble();
	    sc.close();
	    
	    double BMI = weight / (height * height);
	    System.out.println("Your BMI is " + BMI);
	 

	}

}
