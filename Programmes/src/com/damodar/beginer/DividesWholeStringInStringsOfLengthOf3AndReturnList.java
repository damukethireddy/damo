package com.damodar.beginer;

public class DividesWholeStringInStringsOfLengthOf3AndReturnList {

	public static void main(String[] args) {

		String s = "abcdefghi";

		int n = 5;
		split(s, n);

	}

	private static void split(String s, int n) {

		if (s.length() < n) {
			System.out.println("Hi");
			System.out.println(s.substring(0, s.length() ));
		} else {
			System.out.println("Hello");
			System.out.println(s.substring(0, n ));
			split(s.substring(n , s.length() ), n);

		}
	}

}
