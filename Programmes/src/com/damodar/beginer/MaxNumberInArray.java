package com.damodar.beginer;

public class MaxNumberInArray {

	public static void main(String[] args) {

		int ar[] = { 66, 7, 9, 70, 89, 11, 2, 93 };
		int maximum1 = ar[0];
		int maximum2 = ar[0];

		for (int index = 0; index < ar.length; index++) {

			if (maximum1 < ar[index]) {

				maximum2=maximum1;
				maximum1 = ar[index];

			}
			
		}
		
		System.out.println("First Maximum number"+maximum1);
		System.out.println("second Maximum number"+maximum2);

	}

}
