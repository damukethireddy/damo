package com.damodar.beginer;

public class FindOnlyDuplicateNumberInListExample {

	public static void main(String[] args) {

		int inputArray[] = { 1, 2, 3, 4, 5, 5,5, 7, 8, 9, 10,10};
		int length = findDuplicates(inputArray);

		for (int i = length; i < inputArray.length; i++) {

			System.out.println("Elements" + inputArray[i]);
		}

	}

	private static int findDuplicates(int inputArray[]) {

		int length = inputArray.length;
		for (int i = 0; i < length; i++) {

			for (int j = i + 1; j < length; j++) {

				if (inputArray[i] == inputArray[j]) {

					boolean check = isElementExists(inputArray, length, j);

					if (!check) {

						swapElements(j, inputArray, length);

						length -= 1;

					}

				}

			}

		}
		return length;
	}

	private static void swapElements(int index, int inputArray[], int length) {

		int element = inputArray[index];
		for (int i = index; i < length - 1; i++) {

			inputArray[i] = inputArray[i + 1];

		}

		inputArray[length-1] = element;

	}

	private static boolean isElementExists(int[] inputArray, int length, int index) {

		boolean exists = false;

		for (int i = length; i < inputArray.length; i++) {

			if (inputArray[i] == inputArray[index]) {

				exists = true;
				break;
			}

		}
		return exists;
	}

}
