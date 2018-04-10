package com.damodar.beginer;

public class SmallToCaptialConversion {

	public static void main(String[] args) {

		String inputString = new String("java made so easy");

		char[] charArray = inputString.toCharArray();

		for (int i = 0; i < charArray.length; i++) {

			switch (charArray[i]) {

			case 'a':

				charArray[i] = (char) (charArray[i] - 32);
				break;

			case 'e':

				charArray[i] = (char) (charArray[i] - 32);
				break;

			case 'i':

				charArray[i] = (char) (charArray[i] - 32);
				break;

			case 'o':

				charArray[i] = (char) (charArray[i] - 32);
				break;

			case 'u':

				charArray[i] = (char) (charArray[i] - 32);
				break;

			}

			// case:'a'

		}

		System.out.println(String.valueOf(charArray));

	}

}
