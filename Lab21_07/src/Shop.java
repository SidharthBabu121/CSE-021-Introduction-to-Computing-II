import java.util.Random;
import java.util.Scanner;

public class Shop {

	public static int h, t, r;
	Cheese HFog, RHawk, Teleme;

	/*
	 * Shop constructor initializes the 3 types of cheeses sold, along 
	 * with their prices.
	 */
	public Shop() {
		HFog = new Cheese();
		HFog.setName("Humboldt Fog");
		HFog.setPrice(25.00);

		RHawk = new Cheese("Red Hawk");
		RHawk.setPrice(40.50);

		Teleme = new Cheese("Teleme", 17.25);
	}

	/*
	 * Displays the intro message informing the user of various cheeses sold and
	 * Gets the amount of each cheese the user would like to purchase. 
	 */
	private void intro(Scanner input) {
		
		
		System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
		System.out.println(HFog.getName() + ": $" + HFog.getPrice() + " per pound");
		System.out.println(RHawk.getName() + ": $" + RHawk.getPrice() + " per pound");
		System.out.println(Teleme.getName() + ": $" + Teleme.getPrice() + " per pound");

		System.out.print("\nEnter the amount of " + HFog.getName() + " in lbs: ");
		HFog.setAmount(input);

		if (HFog.getAmount()<0||HFog.getAmount()%.5!=0) {
			h = 0;
			do {
				if (HFog.getAmount() < 0) {
					System.out.print("Invalid input. Enter a value >= 0:");
					HFog.setAmount(input);
					h = 1;
				}
				else if (HFog.getAmount()%.5!=0) {
					System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
					HFog.setAmount(input);
					h = 1;
				}
			} while (HFog.getAmount()<0||HFog.getAmount()%.5!=0);

		}else {
			h = 1;
		}


		if (h == 1 && r == 0 && t == 0 ) {
			System.out.print("Enter the amount of " + RHawk.getName() + " in lbs: ");
			RHawk.setAmount(input);

			if (RHawk.getAmount()<0||RHawk.getAmount()%.5!=0) {
				r = 0;
				do {
					if (RHawk.getAmount()<0) {
						System.out.print("Invalid input. Enter a value >= 0:");
						RHawk.setAmount(input);
					}
					else if (RHawk.getAmount()%.5!=0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
						RHawk.setAmount(input);
					}
				} while (RHawk.getAmount()<0||RHawk.getAmount()%.5!=0);

			}else {
				r = 1;
			}
		}


		if (h == 1 && r == 1 && t == 0 ) {
			System.out.print("Enter the amount of " + Teleme.getName() + " in lbs: ");
			Teleme.setAmount(input);

			if (Teleme.getAmount()<0||Teleme.getAmount()%.5!=0) {
				t = 0;

				do {
					if (Teleme.getAmount()<0) {
						System.out.print("Invalid input. Enter a value >= 0:");
						Teleme.setAmount(input);
					}
					else if (Teleme.getAmount()%.5!=0) {
						System.out.print("Invalid input. Enter a value that's multiple of 0.5:");
						Teleme.setAmount(input);
					}
				} while (Teleme.getAmount()<0||HFog.getAmount()%.5!=0);

			} else {
				t = 1;
			}
		}

	}


	/*
	 * Displays the itemized list of all cheeses bought or a special message if none 
	 * were purchased.
	 */
	private void itemizedList(){
		double amt = 0, price = 0;
		if ((HFog.getAmount() + RHawk.getAmount() + Teleme.getAmount()) == 0)
			System.out.println("No items were purchased.");
		else {
			if ((amt = HFog.getAmount()) > 0) {
				price = HFog.getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, HFog.getName(), price, price*amt);
			}
			if ((amt = RHawk.getAmount()) > 0) {
				price = RHawk.getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, RHawk.getName(), price, price*amt);
			}
			if ((amt = Teleme.getAmount()) > 0) {
				price = Teleme.getPrice();
				System.out.printf("%.1f lb of %s @ $%.2f = $%.2f\n", amt, Teleme.getName(), price, price*amt);
			}
			
		
		}
	}

	/*
	 * Calculates the Original Sub Total, which is the price*amount of each 
	 * cheese added together. Returns the Original Sub Total.
	 */
	private double calcSubTotal() {
		double subTotal = 0;
		double HPrice = HFog.getAmount() * HFog.getPrice();
		double RPrice = RHawk.getAmount() * RHawk.getPrice();
		double TPrice = Teleme.getAmount() * Teleme.getPrice();
	
		subTotal = HPrice + RPrice + TPrice;


		return subTotal;
	}

	/*
	 * Calculates discounts based on special offers on Humboldt Fog and Red Hawk, 
	 * stores them in disSpecials[0] and disSpecials[1], and returns the array. 
	 * Minor changes from Lab 04 (identical logic). 
	 */
	private double[] discountSpecials() {
		double[] disSpecials = {0, 0};

		double hfAmt = HFog.getAmount(), rhAmt = RHawk.getAmount();

		if (hfAmt > 0) {
			disSpecials[0]=((int)HFog.getAmount()*(HFog.getPrice()/2));
		}

		if(rhAmt > 0) {
			disSpecials[1]=(int)(RHawk.getAmount()/1.5)*RHawk.getPrice()/2;
		}

		return disSpecials;		
	}

	/*
	 * Displays the Original Sub Total, discounts based on specials, and the New Sub 
	 * Total. Returns the New Sub Total. Identical to Lab 04.
	 */
	private double printSubTotals(double subTotal, double[] disSpecials) {
		System.out.println("\nOriginal Sub Total:               $" + subTotal);
		System.out.println("Specials...");
		if(disSpecials[0]==0&&disSpecials[1]==0) {
			System.out.println("None                           -$0.00");
		}
		else {
			if(disSpecials[0]>0) {
				System.out.println("Humboldt Fog (Buy 1 Get 1 Free): -$"+disSpecials[0]);
			}
			if (disSpecials[1]>0) {
				System.out.println("Red Hawk (Buy 2 Get 1 Free):     -$"+disSpecials[1]);
			}

		}
		double newSubTotal=subTotal-(disSpecials[0]+disSpecials[1]);
		return newSubTotal;
	}

	/*
	 * Calculates the additional discount based on the New Sub Total and displays 
	 * the Final Total. Identical to Lab 04.
	 */
	private void printFinalTotal(double newSubTotal) {
		System.out.println("\nNew Sub Total:                   $" +newSubTotal);
		if(newSubTotal<150) {
			System.out.println("\nAdditional 0% Discount:	       -$0.00");
			System.out.println("Final Total: \t                $" + newSubTotal);
		}
		else if (newSubTotal<250) {
			System.out.print("\nAdditional 10% Discount:	");
			System.out.printf(" -$%.2f\n" , newSubTotal*.10);
			System.out.print("Final Total:");
			System.out.printf("                              $%.2f\n" ,newSubTotal-(newSubTotal*.10));
		}
		else if (newSubTotal>=250) {
			System.out.print("Additional 15% Discount:	");
			System.out.printf(" -$%.2f\n" ,   newSubTotal*.25);
			System.out.print("\nFinal Total:");
			System.out.printf("                              $%.2f\n" ,newSubTotal-(newSubTotal*.25));
		}

	}


	private void printFree(){
		double amt;
		System.out.println();
		System.out.println("Today is your lucky day!");
		if ((amt = HFog.getAmount()) > 0) 
			System.out.println(amt + " lb of Humboldt Fog @ $0 = $" + 0);
		if ((amt = RHawk.getAmount()) > 0) 
			System.out.println(amt + " lb of Red Hawk @ $0 = $" + 0);
		if ((amt = Teleme.getAmount()) > 0) 
			System.out.println(amt + " lb of Teleme @ $0 = $" + 0);
		System.out.println("Total: FREE!!!\n");
	}

	public void run() {

		Scanner input = new Scanner(System.in);
		intro(input);
		double subTotal = calcSubTotal();

		System.out.println();
		System.out.print("Display the itemized list? (1 for yes): ");
		int list = input.nextInt();
		if (list == 1)
			itemizedList();	

		int free = (new Random()).nextInt(100);
		System.out.println("Random num is " + free);
		if (free != 0) {
			double newSubTotal = printSubTotals(subTotal, discountSpecials());
			printFinalTotal(newSubTotal);
		} else {
			printFree();
			return;
		}

		System.out.println();
		System.out.print("Do you wish to redo your whole order? (1 for yes): ");
		int redo = input.nextInt();

		System.out.println();

		if (redo == 1)
			run();
		else
			System.out.println("Thanks for coming!");
		    
	}
}
