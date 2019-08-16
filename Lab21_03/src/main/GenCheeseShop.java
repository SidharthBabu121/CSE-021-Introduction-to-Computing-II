package main;


import java.lang.*;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);
		
		
		System.out.print("Enter the number of Cheeses for shop setup:");
		int MAXCHEESE = input.nextInt();
		
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];
		double[] costs = new double[MAXCHEESE];		
		// Three Special Cheeses
		double hDisc = 0;
		double rDisc = 0;
       
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
      
		double OrigTotalSum = 0;
		double TotalQuant = 0;
		
		for(int i=0; i < MAXCHEESE; i++) {
			System.out.print("\n(" + (i+1) + ") Enter the amount of " + names[i] + " in lb: ");
			amounts[i] = input.nextDouble();
			while (amounts[i] < 0 || amounts[i] % 0.5 != 0) {
				if (amounts[i] < 0) {
				  System.out.print("\tInvalid Input. Enter a value >= 0: ");
				  amounts[i] =input.nextDouble();
				}
				if (amounts[i] % 0.5 != 0) {
				  System.out.print("\tInvalid input. Enter a value that's multiple of 0.5: ");
				  amounts[i] = input.nextDouble();	  
				}
			}
			costs[i] = amounts[i] * prices[i];
			OrigTotalSum += costs[i];
			TotalQuant += amounts[i];
		}
		
		if (TotalQuant > 0 ) {
		   System.out.print("\nDisplay the itemized list? (1 for yes): ");
		   int val = input.nextInt();
		   for (int i = 0; i < MAXCHEESE; i++) {
			System.out.println("\t" + amounts[i] +  " lb of " + names[i] + "@ $" + prices[i] + " = $" + costs[i]);
			
		   }
		}
		else  {
			System.out.println("No items were purchased. ");
		}
		
		System.out.println("\nOriginal Sub Total:                             $"  + OrigTotalSum);
		System.out.println("\nSpecials.........................................................................");
	
	 if(MAXCHEESE > 0) {
		 if (MAXCHEESE == 1) {
				 if (amounts[0] >= 1) {
						if (amounts[0] == 1) {
							 hDisc = (amounts[0]/2) * prices[0];
							 System.out.println("Humboldt Fog (Buy 1 Get 1 Free):               -$" + (hDisc));
							 OrigTotalSum -= hDisc;
						}
						if(amounts[0] > 1) {
							 hDisc = (int)(amounts[0]/2) * prices[0];
							 System.out.println("Humboldt Fog (Buy 1 Get 1 Free):               -$" + (hDisc));
							 OrigTotalSum -= hDisc;
						}
				      } 
		 }else {
	       if (amounts[0] >= 1) {
			if (amounts[0] == 1) {
				 hDisc = (amounts[0]/2) * prices[0];
				 System.out.println("Humboldt Fog (Buy 1 Get 1 Free):               -$" + (hDisc));
				 OrigTotalSum -= hDisc;
			}
			if(amounts[0] > 1) {
				 hDisc = (int)(amounts[0]/2) * prices[0];
				 System.out.println("Humboldt Fog (Buy 1 Get 1 Free):               -$" + (hDisc));
				 OrigTotalSum -= hDisc;
			} 
	      } 
				
		  if (amounts[1] >= 0) {
				
					 double rDisClac  = (int)(amounts[1] * 2) / 3;
					 rDisc = rDisClac/2 * prices[1];
					 System.out.println("RedHawk (Buy 2 Get 1 Free):               -$" + (rDisc));
					 OrigTotalSum -= rDisc;
				 
			   }
		 }
	 }else {
		 System.out.println("None                                            -$0.0");
		  OrigTotalSum = 0;
	 }
		
		System.out.println("New Sub Total:                                  $" + OrigTotalSum);
		
		System.out.println("Discounts........................................................................");
		if (OrigTotalSum > 150 && OrigTotalSum <= 250) {
			OrigTotalSum -= (OrigTotalSum * 0.10);
			System.out.println("The 10 percent discount:                     -$" + (OrigTotalSum * 0.10));
		} 
		if (OrigTotalSum > 250) {
			OrigTotalSum -= (OrigTotalSum * 0.25);
			System.out.println("The 25 percent discount:                     -$" + (OrigTotalSum * 0.25) );
		}
		else if (OrigTotalSum <= 150) {
			System.out.println("No Discount Calculated:                        -$0.00");
		}
		
		
		
		System.out.println("\nFinal Total:                                    $" + (OrigTotalSum));
		
		
	}


	
	
}
