package com.damodar.beginer;

import java.util.Scanner;

public class SumOfDigitsNumber {

	public static void main(String[] args) {

		System.out.println("Please enter the number to find summ of digits");

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();

		System.out.println("Sum of the digits of the given number is " + sumOfDigits(number));

	}

	private static int sumOfDigits(int number) {

		int sum = 0;

		while (number != 0) {

			sum += number % 10;
			number = number / 10;
		}

		return sum;

	}

}
