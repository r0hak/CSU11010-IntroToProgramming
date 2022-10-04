import java.util.Arrays;
import java.util.Scanner;

public class Median {

	public static void main(String[] args) {
		boolean quit = false;
		double[] numbers = null;
		int divisor = 3;
		
		System.out.println("Welcome to the median & rolling average system.");
		Scanner input = new Scanner(System.in);
		do {
			System.out.print("Enter a number (or enter quit): ");
			if (input.hasNext("quit")) {
				quit = true;
			}
			else if (input.hasNextDouble())
			{
				double[] newNumbers = new double[(numbers==null)? 1 : numbers.length+1];
				if (numbers!= null)
					System.arraycopy( numbers,0,newNumbers,0,numbers.length );
					newNumbers[newNumbers.length-1] = input.nextDouble();
					numbers = newNumbers;
					double median = 0;
					median = computeMedian(numbers);
					double average = computeRollingAverage(numbers, divisor);
					String formattedArrayString = convertToString(numbers);
					System.out.printf("The median of %s is %.1f and the rolling average of the last 3 values is %.1f\n",
							formattedArrayString, median, average);
			}
			else {
				System.out.println("Error - Enter any real number or quit.");
				input.next();
			}
		} while (!quit);
		input.close();	
		
	}

	public static double[] createSortedArray( double[] array )
	{
		double[] newArray = null;
		if (array!=null && array.length != 0)
		{
			newArray = new double[array.length];
			newArray = array.clone();
			Arrays.sort(newArray);
		}
		return newArray;
	}
	
	public static double computeMedian( double[] array)
    {
		double median = 0;
		
		if (array == null || array.length == 0 ) 
		{
			return median;
		}
		else {
			array = createSortedArray(array);
			int totalNumbers = array.length;
			if (totalNumbers % 2 != 0)
			{
				totalNumbers = Math.round(totalNumbers/2);
				median = (double)array[totalNumbers];
			}
			else if (totalNumbers % 2 == 0)
			{
				int number = Math.round((totalNumbers-1)/2);
				median = (double)(array[number] + array[totalNumbers / 2]) / 2.0;
			}
		}
        return median;	
    }
	
	public static double computeRollingAverage( double[] array, int divisor)
	{
		double average = 0;
		if ( array == null || array.length == 0 || divisor == 0) {
			return average;
		}
		else {
			if (array.length == divisor)
			{
				for (int index = 0; index < array.length; index++)
				{
					average = ((average + array[index]));
				}
				average = average / divisor;
			}
			else if (array.length > divisor )
			{
				int additionalNumbers = array.length - divisor;
				for (int index = (additionalNumbers); index < array.length; index++)
				{
					average = ((average + array[index]));
				}
				average = average / divisor;
			}
			else if ( divisor <= 0 )
			{ 
				average = 0;
			}
			else if ( divisor > array.length)
			{
				for (int index = 0; index < array.length; index++)
				{
					average = ((average + array[index]));
				}
				average = average / array.length;
			}
		}
		return average;
	}
	
	public static String convertToString ( double[] array )
	{
		String convertedString = "";
		int element = 0;
		int scale = (int) Math.pow(10, 1);
		if (array == null || array.length == 0)
		{
			convertedString = "{ }";
		}	
		else {
			while (element < array.length) {
			array[element] = (double) Math.round(array[element]*scale)/scale;
			++element;
			}
			convertedString = Arrays.toString(array).replace("[", "{ ");
			convertedString = convertedString.replace("]", " }");
		}
		return convertedString;
	}
	
}
