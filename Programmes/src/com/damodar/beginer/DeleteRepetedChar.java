package com.damodar.beginer;

import java.util.Scanner;

public class DeleteRepetedChar {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the string 1");
		String s1 = scanner.nextLine();
		System.out.println("Please enter the string 2");
		String s2 = scanner.nextLine();
		
		removeRepetedChar(s1, s2) ;

	}

	private static void removeRepetedChar(String s1, String s2) {

		char[] ch1array = s1.toCharArray();
		char[] ch2array = s2.toCharArray();

		for (int i = 0; i < ch1array.length; i++) {

			char ch = ch1array[i];
			boolean match = false;

			for (int j = 0; j < ch2array.length; j++) {

				if (String.valueOf(ch).equalsIgnoreCase(String.valueOf(ch2array[j]))) {
					match = true;
					break;

				}

			}

			if (match) {

				s1 = s1.replaceAll(String.valueOf(ch).toUpperCase(), "");
				s1 = s1.replaceAll(String.valueOf(ch).toLowerCase(), "");
				s2 = s2.replaceAll(String.valueOf(ch).toLowerCase(), "");
				s2 = s2.replaceAll(String.valueOf(ch).toUpperCase(), "");

			}

		}

		System.out.println("Resultant string1 is " + s1);
		System.out.println("Resultant string2 is " + s2);

	}

}
