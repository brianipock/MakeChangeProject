package cashregister;

import java.util.*;

public class MakeChange {

	public static void main(String[] args) {

		makeTransaction();

	}// main

	public static void makeTransaction() {
		Scanner register = new Scanner(System.in);
		System.out.print("Hey Clerk!! Enter the price of the item, quit being stoned!");
		float cost = register.nextFloat();
		cost = (float)(cost*100)/100;
		System.out.printf("The item price is: $%.2f", cost);
		System.out.println();
		System.out.print("How much money did the customer just hand you?");
		float payment = register.nextFloat();
		payment = (float)(payment*100)/100;
		System.out.println();
		System.out.printf("The item price is: $%.2f", cost);
		System.out.println();
		System.out.printf("The customer paid: $%.2f", payment);
		System.out.println();

		register.close();
		getMoney(payment, cost);

	}// makeTransaction

	public static void getMoney(float payment, float cost) {
		float change = payment - cost;
		change = (float)(change*100)/100;

		if (cost > payment) {
			System.err.println("You didn't pay enough money,");
			System.err.println(" I will need more money if you want to buy this item.");
		} 

		else if (cost == payment) {
			System.out.println("Thank You, Come Again! (Apu Voice)");
		}
		
		else if (cost <= payment) {
			System.out.println();
			System.out.printf("Give the customer this much change: $%.2f", change);
			System.out.println();
			giveChange(payment, cost, change);
		}
	}// getMoney

	public static void giveChange(float payment, float cost, float change) {
		float billsCents[] = { 20f, 10f, 5f, 1f, 0.25f, 0.10f, 0.05f, 0.01f };
		String values[] = { "Twenty dollar bill", "Ten dollar bill", "Five dollar bill", "One dollar bill", "Quarter", "Dime", "Nickel", "Penny" };
		String valuesPlural[] = { "Twenty dollar bills", "Ten dollar bills", "Five dollar bills", "One dollar bills", "Quarters", "Dimes", "Nickels", "Pennies" };

		for (int i = 0; i < billsCents.length; i++) {
			if (((int) (change / billsCents[i])) == 1) {
				System.out.printf("Give " + (int) (change / billsCents[i]) + " " + values[i] + " in change");
				System.out.println();
				change = change - billsCents[i] * ((int) (change / billsCents[i]));
			}

			if (((int) (change / billsCents[i])) > 1) {
				System.out.println("Give " + (int) (change / billsCents[i]) + " " + valuesPlural[i] + " in change");
				System.out.println();
				change = change - billsCents[i] * ((int) (change / billsCents[i]));
			}
		}
	}

}// class
