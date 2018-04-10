package com.damodar.beginer;

public class Pallandrome100 {

	public static void main(String[] args) {

		for (int i = 10; i < 1000; i++) {

			char[] charArray = String.valueOf(i).toCharArray();

			boolean isPallandrome = true;

			for (int j = 0; j < charArray.length / 2; j++) {

				if (charArray[j] != charArray[charArray.length - 1 - j]) {

					isPallandrome = false;
					break;
				}

			}

			if (isPallandrome) {
				System.out.println(i);
			}

		}

	}

}
