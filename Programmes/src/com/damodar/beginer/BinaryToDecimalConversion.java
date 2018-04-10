package com.damodar.beginer;

import java.util.Scanner;

public class BinaryToDecimalConversion {

	public static void main(String[] args) {

		System.out.println("Please enter the binary number to cinvert into decimal");
		Scanner scanner = new Scanner(System.in);
		int binary = scanner.nextInt();

		int decimalNumber = 0;
		int i = 0;

		while (binary != 0) {

			decimalNumber += (binary % 10) * Math.pow(2, i++);
			binary = binary / 10;

		}

		System.out.println("Enter the decimal value" + decimalNumber);

	}

}
