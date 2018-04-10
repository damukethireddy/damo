package com.damodar.beginer;

import java.util.Scanner;

public class StrungReverse {

	public static void main(String[] args) {
		System.out.println("Please enter the string ");
		
		Scanner scanner= new Scanner(System.in);
		
		String input=scanner.nextLine();
		
		System.out.println(Reverse(input));

	}
	
	private static  String  Reverse(String input) {
		
		 char[] inputCharArray=input.toCharArray();
		 int lenght=inputCharArray.length-1;
		 
		 int mid=inputCharArray.length/2-1;
		 
		 int index=0;
		 
		 while(index<=mid) {
			 
			 char temp=inputCharArray[index];
			 inputCharArray[index]=inputCharArray[lenght-index];
			 inputCharArray[lenght-index]=temp;
			 index++;
			 
			 
		 }
		
		return new String(inputCharArray);
		
		
	}

}
