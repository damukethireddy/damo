package com.damodar.beginer;

import java.util.Scanner;

public class OccuranceDigitInCube {

	public static void main(String[] args) {

		System.out.println("Please enter the number to calculate Cube of Number");

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		System.out.println("enter the digit occurance");
		int digit = scanner.nextInt();

		long cube = number * number * number;
		int count = 0;

		while (cube != 0) {

			if (cube % 10 == digit)
				count++;
			cube = cube / 10;

		}
		System.out.println("Enter the count of the digit" + count);
	}

}
