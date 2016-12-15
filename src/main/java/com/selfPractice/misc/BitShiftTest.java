package com.selfPractice.misc;

public class BitShiftTest {

	public static void main(String args[]) {

		int number = 8; // 0000 1000
		System.out.println("Original number : " + number);

		// left shifting bytes with 1 position
		number = number << 1; // should be 16 i.e. 0001 0000

		// equivalent of multiplication of 2
		System.out.println("value of number after left shift: " + number);

		number = -8;
		// right shifting bytes with sign 1 position
		number = number >> 1; // should be 16 i.e. 0001 0000

		// equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);

		number = -8;
		// right shifting bytes without sign 1 position
		number = number >>> 1; // should be 16 i.e. 0001 0000

		// equivalent of division of 2
		System.out.println("value of number after right shift with sign: " + number);
		
		number = 2; //0010
	    
		//example of bitwise unary complement operator (~)
		System.out.println(" value of number before: " + number);
		System.out.println(" value of number after negation: " + ~number);
	}

}