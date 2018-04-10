package com.damodar.beginer;

import java.util.Scanner;

public class ReverseNumber {

	public static void main(String[] args) {

		System.out.println("Please Enter the number");

		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();
		
		System.out.println(reverseNumber(number));
		
		

	}
	
	private static int reverseNumber(int number) {

		int reverse = 0;

		while (number != 0) {

			int digit = number % 10;
			reverse = digit + reverse * 10;

			number = number / 10;

		}
		return reverse;
	}

}
