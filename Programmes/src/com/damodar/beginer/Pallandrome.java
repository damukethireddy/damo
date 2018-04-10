package com.damodar.beginer;

import java.util.Scanner;

public class Pallandrome {

	public static void main(String[] args) {

		System.out.println("Please Enter the string ");
		Scanner scanner = new Scanner(System.in);
		String palandrome = scanner.nextLine();

		boolean checkPalandrome = isPalandrome(palandrome);

		if (checkPalandrome)
			System.out.println("Gieven String is palandrome");
		else
			System.out.println("Gieven String is not  palandrome");

	}

	private static boolean isPalandrome(String palandrome) {

		int index = 0;

		boolean checkPalandrome = true;
		int len = palandrome.length();

		while (index < len / 2 - 1) {

			if (palandrome.charAt(index) != palandrome.charAt(len - index - 1)) {
				checkPalandrome = false;
				break;
			}
			index++;
		}
		return checkPalandrome;
	}

}
