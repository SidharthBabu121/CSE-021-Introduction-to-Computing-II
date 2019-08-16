package main;


import java.util.Scanner;

public class CheeseShop {
	
	public static double StandPricHum = 25.0;
	public static double StandPricRed = 40.5;
	public static double StandPricTel = 17.25;
	public static double StandPackgWeight = 0.5;
	
	static Scanner input = new Scanner (System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	double choiceHum;
	double choiceRed;
	double choiceTel;
		
		
	double PricDisHum = 0;	
	double PricDisRed = 0;
	double PriDisTel = 0;
	
	double PricDisTot = PricDisHum + PricDisRed;

	
	
	System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
	System.out.println("- Humboldt Fog: $25.0 per pound\n" + "- Red Hawk: $40.5 per pound\n" + "- Teleme: $17.25 per pound");
	
	System.out.print("\n(1)Enter the amount of Humboldt Fog in lbs: ");
	choiceHum = input.nextDouble();
	
	InvalidInputChecker(choiceHum);
	
	double DisHum = (choiceHum / StandPackgWeight) * StandPackgWeight;
	double TotHum = DisHum + choiceHum;
	double PriHum = TotHum * StandPricHum;
	
	System.out.print("(2)Enter the amount of Red Hawk in lbs: "); 
	choiceRed = input.nextDouble();
	
	InvalidInputChecker(choiceRed);
	
	double DisRed = (choiceRed / (StandPackgWeight * 2)) * StandPackgWeight;
	double TotRed = DisRed + choiceRed;
	double PriRed = TotRed * StandPricRed;
	
	System.out.print("(3)Enter the amount of Teleme in lbs: ");
	 choiceTel = input.nextDouble();
	
	InvalidInputChecker(choiceTel);
	
	double PriTel = choiceTel * StandPricTel;
	
	
	double SubTotal = PriHum + PriRed + PriTel;
	double DisTotal = DisHum + DisRed;
		
	
	if (SubTotal > 0 ) {
		System.out.print("\nDisplay the itemized list? (1 for yes): ");
		int val = input.nextInt();
		System.out.println(TotHum +  " lb of Humboldt Fog @ $25.0 = $" + PriHum);
		System.out.println(TotRed +  " lb of Red Hawk @ $40.5 = $" + PriRed);
		System.out.println(choiceTel +  " lb of Teleme @ $17.25 = $" + PriTel);
		
	}
	else  {
		System.out.println("\nNo items were purchased. ");
	}


	System.out.println("\nSubTotal:                          $" + SubTotal);
	System.out.println("Discounts......");
	if (DisTotal > 0) {
		if (DisHum > 0) {
			   PricDisHum = DisHum * StandPricHum;
			   System.out.println("Humboldt Fog (Buy 1 Get 1 Free):  -$" + PricDisHum);
		   }else {
			   PricDisHum = 0;
		   }
		   if (DisRed > 0) {
			   PricDisRed = DisRed * StandPricRed;
			   System.out.println("Red Hawk (Buy 2 Get 1 Free):      -$" + PricDisRed);
		   }else {
			   PricDisRed = 0;
		   }
	}else {
		System.out.println("None                              -$" + PricDisTot);
	}
	 double Total = SubTotal - PricDisHum - PricDisRed;
	System.out.println("\nTotal:                             $" + Total);
	
  }
	
	
	/*< Method 1 >
	 * Invalid Input Checker Method: 
	 * 		Checker whether value inputed by user is either greater than 0 and/or
	 * 		a multiple of the standard package weight
	 **/
	 
	public static void InvalidInputChecker (double userInput) {
		while (userInput < 0 || userInput % StandPackgWeight != 0) {
			if (userInput < 0) {
			  System.out.print("\tInvalid Input. Enter a value >= 0: ");
			  userInput =input.nextDouble();
			}
			if (userInput % StandPackgWeight != 0) {
			  System.out.print("\tInvalid input. Enter a value that's multiple of 0.5: ");
			  userInput = input.nextDouble();
			}
		}
	}
	
}
