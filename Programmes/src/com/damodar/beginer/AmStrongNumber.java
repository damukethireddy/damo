package com.damodar.beginer;

import java.util.Scanner;

public class AmStrongNumber {

	public static void main(String[] args) {

		System.out.println("enter the number to check the Amstrong");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		if (number == checkAmstrong(number)) {

			System.out.println("Amstrong Number");

		} else {

			System.out.println("Not Amstrong Number");

		}

	}

	private static long checkAmstrong(int number) {

		long sumOfCubes = 0;

		while (number != 0) {

			int digit = number % 10;

			sumOfCubes += digit * digit * digit;
			number = number / 10;

		}
		return sumOfCubes;
	}

}
