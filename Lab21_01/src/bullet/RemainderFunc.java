package bullet;

import java.util.Scanner;
public class RemainderFunc {

	public static void main(String[] args) {
	
		int maxnum;
		int divisor;
		String start = "y";
		
		while (start.equals("y")) {
			Scanner input = new Scanner(System.in);
			
			System.out.println("-------------------------------------------------------------------------------------");
			System.out.print("Please enter the max number:");
			maxnum = input.nextInt();
			while (maxnum < 0) {
				System.out.print("Invalid input. Please enter a valid max number (>= 0):");
				maxnum = input.nextInt();
			}
			System.out.print("Please enter the divisor:");
			divisor = input.nextInt();
			while (divisor <= 0) {
				System.out.print("Invalid input. Please enter a valid divisor (> 0):");
				divisor = input.nextInt();
			}
			 if (divisor >= maxnum)  {
	            	System.out.println("No number were found.");
	            	break;
			 }
			
			System.out.println("\nMultiples of " + divisor + " between 1 and " + maxnum + "(inclusive) are: ");
			
			for (int i = divisor; i <= maxnum; i+=divisor) {
		        System.out.println(i);
		            if ((i > maxnum))
		                break;
			  }
			System.out.println("-------------------------------------------------------------------------------------");
			
		System.out.print("Would you like to try again? y or n:");
		start = input.next();
		}
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("\nGoodbye!");
	
	}

}
