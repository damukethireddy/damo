package com.damodar.beginer;

public class SmallestLargest {

	public static void main(String[] args) {

		int inputArray[] = { 10, 3, 20, 90, 0, 15, 100 };

		int smallest = inputArray[0];
		int biggest = inputArray[0];

		for (int i = 0; i < inputArray.length; i++) {

			if (inputArray[i] < smallest) {
				smallest = inputArray[i];
			} else if (inputArray[i] > biggest) {
				biggest = inputArray[i];

			}

		}

		System.out.println(">>>>>>>>>>>>>>>>smallest>>>>>>>" + smallest);
		System.out.println(">>>>>>>>>>>>>>>>biggest>>>>>>>" + biggest);

	}

}
