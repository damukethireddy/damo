package com.damodar.beginer;

import java.util.Scanner;

public class PerfectNumberExample {

	public static void main(String[] args) {

		System.out.println("Please entrer the number to check perfect number or not");

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		int sum = 1;

		for (int i = 2; i <= number / 2; i++) {

			if (number % i == 0) {

				sum += i;

			}
		}

		if (sum == number) {
			System.out.println("Given Number is perfect number");
		} else {

			System.out.println("Given Number is not perfect number");

		}
	}

}
