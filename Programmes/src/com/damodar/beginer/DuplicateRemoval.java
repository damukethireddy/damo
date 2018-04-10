package com.damodar.beginer;

public class DuplicateRemoval {

	public static void main(String[] args) {

		int[] duplicateSortedAr = { 1,1, 3, 7, 8, 8, 9, 14, 16, 16, 17, 17 };

		int size = removeDuplicates(duplicateSortedAr);
				 
		for (int i = 0; i < size; i++) {

			System.out.println(duplicateSortedAr[i]);
		}
	}

	private static int removeDuplicates(int[] duplicateSortedAr) {

		int len = duplicateSortedAr.length;
		for (int i = 0; i < len - 1; i++) {

			if (duplicateSortedAr[i] == duplicateSortedAr[i + 1]) {
				
				swap(i, duplicateSortedAr, len);
				len -= 1;
				
				System.out.println(i + "  "+ duplicateSortedAr[i] + " Length=="+len);
			}
		}
		return len;
	}

	private static void swap(int index, int[] duplicateSortedAr, int len) {

		for (int i = index; i < len - 1; i++) {

			duplicateSortedAr[i] = duplicateSortedAr[i + 1];
		}

	}

}
