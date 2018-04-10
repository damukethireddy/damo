package com.damodar.beginer;

public class SumOfNumbers {

	public static void main(String... args) {
		int[] ar = { 2, 4, 4, 2, 6, 1, 1 };

		System.out.print("In ar=[");
		for (int n : ar) {
			System.out.print(n + " ");
		}
		System.out.print("] : ");
		int findIndex = findIndex(ar);
		System.out.println(findIndex != -1 ? "sum of elements on left(i.e. from index 0 to " + findIndex
				+ ") = sum of elements on right(i.e. from index " + (findIndex + 1) + " to " + (ar.length - 1) + ")"
				: "No index found where  sum of elements on left = sum of elements on right");

	}

	/**
	 * Finds index such that > sum of elements on whose left is equal to sum of
	 * elements on right
	 */
	public static int findIndex(int[] ar) {

		int leftIndex = 0, rightIndex = ar.length - 1;
		int leftSum = 0, rightSum = 0;

		while (leftIndex <= rightIndex) {
			if (leftSum > rightSum)
				rightSum = rightSum + ar[rightIndex--];
			else
				leftSum = leftSum + ar[leftIndex++];
		}

		if (leftSum == rightSum)
			return rightIndex;
		else
			return -1; // appropriate index not found

	}

}