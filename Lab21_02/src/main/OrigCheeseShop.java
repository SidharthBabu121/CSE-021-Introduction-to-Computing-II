package main;


import java.util.Scanner;

public class OrigCheeseShop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	double PricDisHum = 0;	
	double PricDisRed = 0;
	double PricDisTot = PricDisHum + PricDisRed;

	Scanner input = new Scanner (System.in);
	
	
	System.out.println("We sell 3 kinds of Cheese (in 0.5 lb packages):");
	System.out.println("- Humboldt Fog: $25.0 per pound\n" + "- Red Hawk: $40.5 per pound\n" + "- Teleme: $17.25 per pound");
	
	System.out.print("\n(1)Enter the amount of Humboldt Fog in lbs: ");
	double choiceHum = input.nextDouble();
	while (choiceHum < 0 || choiceHum % 0.5 != 0) {
		if (choiceHum < 0) {
		  System.out.print("\tInvalid Input. Enter a value >= 0: ");
		  choiceHum =input.nextDouble();
		}
		if (choiceHum % 0.5 != 0) {
		  System.out.print("\tInvalid input. Enter a value that's multiple of 0.5: ");
		  choiceHum = input.nextDouble();
		}
	}
	
	double DisHum = (choiceHum / 0.5) * 0.5;
	double TotHum = DisHum + choiceHum;
	double PriHum = TotHum * 25.0;
	
	
	System.out.print("(2)Enter the amount of Red Hawk in lbs: "); 
	double choiceRed = input.nextDouble();
	while (choiceRed < 0 || choiceRed % 0.5 != 0) {
		if (choiceRed < 0) {
		  System.out.print("\tInvalid Input. Enter a value >= 0: ");
		  choiceRed =input.nextDouble();
		}
		if (choiceRed % 0.5 != 0) {
		  System.out.print("\tInvalid input. Enter a value that's multiple of 0.5: ");
		  choiceRed = input.nextDouble();
		}
	}
	
	double DisRed = (choiceRed / 1.0) * 0.5;
	double TotRed = DisRed + choiceRed;
	double PriRed = TotRed * 40.5;
	
	System.out.print("(3)Enter the amount of Teleme in lbs: ");
	double choiceTel = input.nextDouble();
	while (choiceTel < 0 || choiceTel % 0.5 != 0) {
		if (choiceTel < 0) {
		  System.out.print("\tInvalid Input. Enter a value >= 0: ");
		  choiceTel =input.nextDouble();
		}
		if (choiceTel % 0.5 != 0) {
		  System.out.print("\tInvalid input. Enter a value that's multiple of 0.5: ");
		  choiceTel = input.nextDouble();
		}
		
	}
	
	double PriTel = choiceTel * 17.25;
	
	
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
		System.out.println("No items were purchased. ");
	}


	System.out.println("\nSubTotal:                          $" + SubTotal);
	System.out.println("Discounts......");
	if (DisTotal > 0) {
		if (DisHum > 0) {
			   PricDisHum = DisHum * 25.0;
			   System.out.println("Humboldt Fog (Buy 1 Get 1 Free):  -$" + PricDisHum);
		   }else {
			   PricDisHum = 0;
		   }
		   if (DisRed > 0) {
			   PricDisRed = DisRed * 40.5;
			   System.out.println("Red Hawk (Buy 2 Get 1 Free):      -$" + PricDisRed);
		   }else {
			   PricDisRed = 0;
		   }
	}else {
		System.out.println("None        \t-$" + PricDisTot);
	}
	 double Total = SubTotal - PricDisHum - PricDisRed;
	System.out.println("\nTotal:                              $" + Total);
	
  }
	
	
	
}
