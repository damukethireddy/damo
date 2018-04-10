package com.damodar.beginer;

public class BubbleSort {

	public static void main(String[] args) {
		int input[] = { 90, 19, 3, 8, 30, 29, 40 };

		bubbleSort(input);

		for (int i = 0; i < input.length; i++) {

			System.out.println(input[i] + " ");

		}

	}

	public static void bubbleSort(int input[]) {

		for (int i = 0; i < input.length; i++) {

			for (int j = i + 1; j < input.length; j++) {

				if (input[i] < input[j]) {

					int element = input[i];
					input[i] = input[j];
					input[j] = element;

				}

			}
		}

	}

}
