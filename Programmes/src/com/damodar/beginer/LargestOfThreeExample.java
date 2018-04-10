package com.damodar.beginer;

import java.util.Scanner;

public class LargestOfThreeExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the value a");
		int a = scanner.nextInt();
		System.out.println("Please enter the value b");
		int b = scanner.nextInt();
		System.out.println("Please enter the value c");
		int c = scanner.nextInt();

		if (a > b && a > c) {

			System.out.println("value a is greater " + a);

		}
		else if (b > a && b > c) {

			System.out.println("value b is greater " + b);

		}
		else if (c > a && c > b) {

			System.out.println("value c is greater " + c);

		}
		else if (a == b && b == c) {
			System.out.println("All the values a,b and c are equal");
		}
		

	}

}
