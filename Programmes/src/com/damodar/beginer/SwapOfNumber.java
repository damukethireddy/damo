package com.damodar.beginer;

import java.util.Scanner;

public class SwapOfNumber {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter number 1 to swap");

		int a = scanner.nextInt();

		System.out.println("enter number 2 to swap");

		int b = scanner.nextInt();

		a = a + b;

		b = a - b;

		a = a - b;

		System.out.println("enter number 1 after swap" + a);

		System.out.println("enter number 2 after swap" + b);

	}

}
