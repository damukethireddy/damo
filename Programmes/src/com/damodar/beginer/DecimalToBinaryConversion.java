package com.damodar.beginer;

import java.util.Scanner;

public class DecimalToBinaryConversion {

	public static void main(String[] args) {

		System.out.println("Please enter the Number to Convert decimal to binary number");

		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();

		String binary = "";

		while (number != 0) {

			binary = number % 2 + binary;

			number = number / 2;
		}

		System.out.println("Binary Number is>>>>>" + binary);

	}

}
