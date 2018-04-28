package com.skilldistillery.makechange;

import java.util.Scanner;

public class MakeChangeApp {

	public static void main(String[] args) {

		int change = askUserPriceAndPayment();
		giveChange(change);

	}

	public static int askUserPriceAndPayment()

	{
		double price;
		double payment;
		boolean notEnough = true;
		do {
			Scanner kb = new Scanner(System.in);
			System.out.print("Please enter the price of the item: ");
			price = kb.nextDouble();
			System.out.print("Please enter how much you're paying with: ");
			payment = kb.nextDouble();
			if (payment < price) {
				System.out.println("Please try again with enough money.");
				notEnough = true;
				continue;
			} else {
				notEnough = false;
			}

		} while (notEnough);
		int roundedBalance = (int) (Math.round(100 * (payment - price)));
		System.out.printf("Amount: %.2f, ", price);
		System.out.printf("Tendered: " + "%.2f" + ", Result: ", payment);
		return (roundedBalance);

	}

	public static void giveChange(int change) {
		int count = 0;
		int balance = change;
		String tillStr[] = { "hundred dollar bill(s), ", "fifty dollar bill(s), ", "twenty dollar bill(s), ",
				"ten dollar bill(s), ", "five dollar bill(s), ", "one dollar bill(s), ", "quarter(s), ", "dime(s), ",
				"nickle(s), ", "penny(s)." };
		int till[] = { 10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1 };
		for (int i = 0; i < till.length; i++) {
			count = 0;

			if (balance < till[i]) {
				continue;

			}
			while (balance >= till[i]) {
				balance -= till[i];
				count++;

			}

			if (count != 0) {
				System.out.print(count + " " + tillStr[i]);
			}

		}

	}

}
