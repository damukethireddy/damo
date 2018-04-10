package com.damodar.beginer;

import java.util.Scanner;

public class GradeProgramUsingSwitchStatementExample {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter the grade ");
		String input = scanner.next().toUpperCase();

		char grade = input.charAt(0);

		switch (grade) {

		case 'A':
			System.out.println("Grade A  ->   marks >=80");
			break;

		case 'B':
			System.out.println("Grade B  ->  marks >=60 and less than 80");
			break;

		case 'C':
			System.out.println("Grade C  ->  marks >=40 and less than 60");
			break;

		case 'F':
			System.out.println("Grade F -> marks <=40");
			break;

		default:
			System.out.println("Invalid  grade is passed");
			break;

		}

	}

}
