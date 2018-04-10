package com.damodar.beginer;

import java.util.Scanner;

public class BinaryNumberCheck {

	public static void main(String[] args) {
		System.out.println("Please enter the number to binary Number");
		Scanner scanner = new Scanner(System.in);

		int number = scanner.nextInt();

		boolean check = IsBinaryNumber(number);

		if (check) {

			System.out.println("Given number " + number + " binary Number");

		} else {

			System.out.println("Given number " + number + "is not  binary Number");

		}
	}

	private static boolean IsBinaryNumber(int number) {

		boolean isBinary = true;

		while (number != 0) {

			if (number % 10 > 1) {
				isBinary = false;
				break;

			}
			number = number / 10;
		}

		return isBinary;

	}

}
