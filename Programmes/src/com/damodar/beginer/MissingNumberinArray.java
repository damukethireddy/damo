package com.damodar.beginer;

public class MissingNumberinArray {

	public static void main(String[] args) {

		int inpuArray[] = { 3, 4, 5, 10, 20, 30, 100 };

		int currentIndex = 0;

		for (int i = 1; i <= 100; i++) {

			if (currentIndex < inpuArray.length && i == inpuArray[currentIndex]) {

				while (currentIndex < inpuArray.length && i == inpuArray[currentIndex]) {
					currentIndex++;
				}

			} else {
				System.out.print(" " + i);
			}
		}

	}

}
