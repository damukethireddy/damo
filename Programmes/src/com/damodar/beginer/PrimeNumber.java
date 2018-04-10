package com.damodar.beginer;

import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		System.out.println("enter the numbr to check the prime number ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		System.out.println("nuber is prime number" + isPrimeNumber(number));

	}

	private static boolean isPrimeNumber(int number) {

		boolean isPrime = true;

		int i = 2;

		while (i < number / 2) {

			if (number % i == 0) {
				isPrime = false;
				break;
			}
			i++;
		}
		return isPrime;
	}

}
