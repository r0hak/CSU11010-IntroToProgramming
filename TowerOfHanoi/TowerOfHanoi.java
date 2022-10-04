import java.util.Scanner;

public class TowerOfHanoi {
	static void towerOfHanoi(int n, char rodOne, char rodThree, char rodTwo) 
		{ 
		if (n == 1) 
		{ 
			System.out.println("Move disk 1 from rod "+ 
								rodOne+" to rod "+ rodThree); 
			return; 
		} 
		towerOfHanoi(n - 1, rodOne, rodTwo, rodThree); 
		System.out.println("Move disk "+ n + " from rod " + 
							rodOne +" to rod " + rodThree ); 
		towerOfHanoi(n - 1, rodTwo, rodThree, rodOne); 
		} 
	public static void  main(String args[]) 
		{ 
		Scanner input = new Scanner(System.in);
        System.out.print("Input the number of disks to move: ");
        int n = input.nextInt();

        towerOfHanoi(n, 'A', 'C', 'B');
		} 
}

	
