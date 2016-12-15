package com.selfPractice.dynamic;

import java.util.Arrays;

public class CountNumberOfWaysToReachGivenScoreInGame {
	// A C program to count number of possible ways to a given score
	// can be reached in a game where a move can earn 3 or 5 or 10

	// Returns number of ways to reach score n
	static int count(int n)
	{
		// table[i] will store count of solutions for
		// value i.
		int[] table = new int[n+1];
		int i;
		
		// Initialize all table values as 0
		Arrays.fill(table, 0);

		// Base case (If given value is 0)
		table[0] = 1;

		// One by one consider given 3 moves and update the table[]
		// values after the index greater than or equal to the
		// value of the picked move
		for (i=3; i<=n; i++)
			table[i] += table[i-3];
		for (i=5; i<=n; i++)
			table[i] += table[i-5];
		for (i=10; i<=n; i++)
			table[i] += table[i-10];

		return table[n];
	}


	// Driver program
	public static void main(String[] args)
	{
		int n = 20;
		System.out.println("Count for %d is %d\n"+ n+" "+count(n));

		n = 13;
		System.out.println("Count for %d is %d"+ n+" "+count(n));
	}

}
