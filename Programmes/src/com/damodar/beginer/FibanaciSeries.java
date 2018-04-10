package com.damodar.beginer;

public class FibanaciSeries {

	public static void main(String[] args) {
		int a = 0;
		int b = 1;

		System.out.println(a);
		System.out.println(b);

		int n = 10;
		while (n > 0) {

			System.out.println(a + b);

			b = a+b;
			
			a=b-a;

			n -= 1;

		}

	}

}
