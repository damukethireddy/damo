package com.damodar.beginer;

import java.util.Scanner;

public class ForiegnHeatToCelsis {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the temperature");
		float temparatue = scanner.nextFloat();

		System.out.println("Please enter 1 for conversion of foriegn heat 2 for celsis");

		int option = scanner.nextInt();

		switch (option) {

		case 1:

			temparatue = ((temparatue - 32) * 5) / 9;

			System.out.println("converting foriegn to celsis " + temparatue);
			break;

		case 2:

			temparatue = (9 * temparatue / 5) + 32;
			System.out.println("Converting celsis to foriegn heat" + temparatue);
			break;

		default:

			System.out.println("Invalid option");
			break;

		}

	}

}
