package com.damodar.beginer;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {

		System.out.println("Please enter the factorial number");

		Scanner sc = new Scanner(System.in);

		System.out.println("factorial of given number" + factorial(sc.nextInt()));

		// int factorial=
	}

	private static int factorial(int number) {

		if (number <= 1)
			return number;

		return number * factorial(number - 1);
	}

}
