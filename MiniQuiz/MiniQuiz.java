import java.util.Scanner;

public class MiniQuiz {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		int value1 = input.nextInt();
		int value2 = input.nextInt();
		if ((value1 > 0) && (value2 > 0))
		{
		   int result = 0;
		   int count = 1;
		   while (count <= value1)
		   {
		      int temp = 1;
		      for (int count2 = 0; (count2 < value2); count2++)
		      {
		         temp *= count;
		      }
		      result += temp;
		      count++;
		   }
		}

	}

}
