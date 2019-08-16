
package main;

import java.util.Random;
import java.util.Scanner;

public class Error {

	public static void main(String[] args) {

Scanner input = new Scanner (System.in);
		
		
		System.out.print("Enter the number of Cheeses for shop setup:");
		int MAXCHEESE = input.nextInt();
		
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];
		double[] costs = new double[MAXCHEESE];		
		// Three Special Cheeses
       
		System.out.println("\nWe sell " + MAXCHEESE + " kinds of Cheese:");
		
		if (MAXCHEESE >= 1) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			System.out.println(" - " +names[0] + ": $" + prices[0] + " per pound");
		}
		if (MAXCHEESE >= 2) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
			System.out.println(" - " + names[1] + ": $" + prices[1] + " per pound");
		}
	    if(MAXCHEESE >= 3) {
	    	names[2] = "Teleme";
			prices[2] = 17.25;
			System.out.println(" - " + names[2] + ": $" + prices[2] + " per pound");
	    }
 		Random ranGen = new Random(100);

		for (int i = 3; i < MAXCHEESE; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(" - " + names[i] + ": $" + prices[i] + " per pound");
		}
	}

}
