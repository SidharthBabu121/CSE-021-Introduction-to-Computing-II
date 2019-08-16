
package main;
import java.util.Random;
import java.util.Scanner;

public class GenCheeseShopv2 {

	/*
	 * Displays the intro message informing the user of various cheeses sold 
	 * while populating the names and prices arrays, and initializing the
	 * amounts array.
	 */
	
	public static void intro(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		
		System.out.println("\nWe sell " + amounts.length + " kinds of Cheese:");
		
		if (amounts.length >= 1) {
			names[0] = "Humboldt Fog";
			prices[0] = 25.00;
			System.out.println(" - " +names[0] + ": $" + prices[0] + " per pound");
		}
		if (amounts.length >= 2) {
			names[1] = "Red Hawk";
			prices[1] = 40.50;
			System.out.println(" - " + names[1] + ": $" + prices[1] + " per pound");
		}
	    if(amounts.length >= 3) {
	    	names[2] = "Teleme";
			prices[2] = 17.25;
			System.out.println(" - " + names[2] + ": $" + prices[2] + " per pound");
	    }
 		Random ranGen = new Random(100);

		for (int i = 3; i < amounts.length; i++) {
			names[i] = "Cheese Type " + (char)('A' + i);
			prices[i] = ranGen.nextInt(1000)/100.0;
			amounts[i] = 0;

			System.out.println(" - " + names[i] + ": $" + prices[i] + " per pound");
		}
		

	}
	
	/*
	 * Gets the amount of each cheese the user would like to purchase and populates
	 * the amounts array with the user inputs. Performs with input validation 
	 * (amount >= 0 and multiple of 0.5).
	 */
	public static void getAmount(Scanner sc, String[] names, double[] amounts) {
		// Fill-in
		
		for(int i=0; i < amounts.length; i++) {
			System.out.print("\n(" + (i+1) + ") Enter the amount of " + names[i] + " in lb: ");
			amounts[i] = sc.nextDouble();
			while (amounts[i] < 0 || amounts[i] % 0.5 != 0) {
				if (amounts[i] < 0) {
				  System.out.print("\tInvalid Input. Enter a value >= 0: ");
				  amounts[i] = sc.nextDouble();
				}
				if (amounts[i] % 0.5 != 0) {
				  System.out.print("\tInvalid input. Enter a value that's multiple of 0.5: ");
				  amounts[i] = sc.nextDouble();	  
				}
			}
		
		}
		
	}

	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	public static void itemizedList(String[] names, double[] prices, double[] amounts) {
		// Fill-in
		
		double TotalQuant = 0;
		
		for (int i = 0; i < amounts.length; i++) {
			TotalQuant += amounts[i];
		}
	
		if (TotalQuant > 0 ) {
			   for (int i = 0; i < amounts.length; i++) {
				System.out.println("\t" + amounts[i] +  " lb of " + names[i] + "@ $" + prices[i] + " = $" + (prices[i] *amounts[i]));
				
			   }
			}
			else  {
				System.out.println("No items were purchased. ");
			}
		 
	}
	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	public static double calcSubTotal(double[] prices, double[] amounts) {
		double subTotal = 0;
		 for (int i = 0; i < amounts.length; i++) {
			 subTotal += (amounts[i] * prices[i]);
			 
		 }
		return subTotal;
		
	}

	/*
	 *  Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 *  stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 */
	public static double[] discountSpecials(double[] amounts, double[] prices){
		// Fix
		
		double[] disSpecials = new double[amounts.length];
		if(amounts.length > 0) {
			 if (amounts.length == 1) {
					 if (amounts[0] >= 1) {
							if (amounts[0] == 1) {
								 disSpecials[0] = (amounts[0]/2) * prices[0];
								
							}
							if(amounts[0] > 1) {
								disSpecials[0] = (int)(amounts[0]/2) * prices[0];
								 
							}
					      } 
			 }else {
		       if (amounts[0] >= 1) {
				if (amounts[0] == 1) {
					disSpecials[0] = (amounts[0]/2) * prices[0];
					 
				}
				if(amounts[0] > 1) {
					disSpecials[0] = (int)(amounts[0]/2) * prices[0];
					
				} 
		      } 
					
			  if (amounts[1] >= 0) {
					
						 double rDisClac  = (int)(amounts[1] * 2) / 3;
						 disSpecials[1] = rDisClac/2 * prices[1];
				   }
			 }
		 }
		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total.
	 */
	public static double printSubTotals(double subTotal, double[] disSpecials) {
		double newSubTotal = subTotal;
		System.out.println("\nOriginal Sub Total:                             $"  + subTotal);
		System.out.println("\nSpecials.........................................................................");
		
    if (disSpecials.length > 0) {
	    if(disSpecials.length == 1 )	 {
	    	 if (disSpecials[0] > 0) {
		  			System.out.println("Humboldt Fog (Buy 1 Get 1 Free):               -$" + (disSpecials[0]));
		  			newSubTotal -= disSpecials[0];
		  	      } 
	      }else {
	    	  if (disSpecials[0] > 0) {
	  			System.out.println("Humboldt Fog (Buy 1 Get 1 Free):               -$" + (disSpecials[0]));
	  			newSubTotal -= disSpecials[0];
	  	      } 
	  				
	  		  if (disSpecials[1] > 0) {
	  				 System.out.println("RedHawk (Buy 2 Get 1 Free):               -$" + (disSpecials[1]));
	  				 newSubTotal -= disSpecials[1];
	  			 }
	      }
	 }else {
		 System.out.println("None                                            -$0.0");
		 newSubTotal = 0;
	 }
		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total.
	 */
	public static void printFinalTotal(double newSubTotal) {
		// Fill-in
		System.out.println("New Sub Total:                                  $" + newSubTotal);
		
		System.out.println("Discounts........................................................................");
		if (newSubTotal > 150 && newSubTotal <= 250) {
			newSubTotal -= (newSubTotal * 0.10);
			System.out.println("The 10 percent discount:                     -$" + (newSubTotal * 0.10));
		} 
		if (newSubTotal > 250) {
			newSubTotal -= (newSubTotal * 0.25);
			System.out.println("The 25 percent discount:                     -$" + (newSubTotal * 0.25) );
		}
		else if (newSubTotal <= 150) {
			System.out.println("No Discount Calculated:                        -$0.00");
		}
		
		
		
		System.out.println("\nFinal Total:                                    $" + (newSubTotal));
		
		
	   }


	/*
	 * Program starts here
	 */
	public static void main(String[] args) {

		final int MAXCHEESE;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of Cheeses for shop setup: ");
		MAXCHEESE = sc.nextInt();

		// DO NOT CHANGE ANYTHING BELOW
		String[] names = new String[MAXCHEESE];
		double[] prices = new double[MAXCHEESE];
		double[] amounts = new double[MAXCHEESE];

		intro(names, prices, amounts);

		getAmount(sc, names, amounts);

		double subTotal = calcSubTotal(prices, amounts);
		
		
		if (MAXCHEESE != 0 ) {
			System.out.print("\nDisplay the itemized list? (1 for yes) ");
			int display = sc.nextInt();
			
			if (display == 1) {
				itemizedList(names, prices, amounts);
			}
		}

		double newSubTotal = printSubTotals(subTotal, discountSpecials(amounts, prices));
		
		printFinalTotal(newSubTotal);
		
		sc.close();
	}
}