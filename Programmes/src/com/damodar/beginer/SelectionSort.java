package com.damodar.beginer;

public class SelectionSort {

	public static void main(String[] args) {

		int[] inputArray = { 10, 2, 3, 5, 20, 25, 40 };
		inputArray = selectionSort(inputArray);

		for (int i = 0; i < inputArray.length; i++) {

			System.out.println(inputArray[i]);
		}

	}

	private static int[] selectionSort(int[] inputArray) {

		int SelectionSortArray[] = new int[inputArray.length];

		for (int i = 0; i < SelectionSortArray.length; i++) {

			int minIndex = getMinIndex(inputArray);

			SelectionSortArray[i] = inputArray[minIndex];
			inputArray[minIndex] = Integer.MAX_VALUE;

		}

		return SelectionSortArray;

	}

	private static int getMinIndex(int[] inputArray) {

		int index = 0;
		for (int i = 1; i < inputArray.length; i++) {

			if (inputArray[index] > inputArray[i]) {

				index = i;
			}

		}
		return index;
	}

}
