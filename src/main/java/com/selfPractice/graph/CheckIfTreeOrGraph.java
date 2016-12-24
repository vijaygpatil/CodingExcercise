package com.selfPractice.graph;

public class CheckIfTreeOrGraph {
	// C++ program to check whether input degree
	// sequence is graph or tree

	// Function returns true for tree
	// false for graph
	boolean check(int degree[], int n)
	{
		// Find sum of all degrees
		int deg_sum = 0;
		for (int i = 0; i < n; i++)
			deg_sum += degree[i];

		// Graph is tree if sum is equal to 2(n-1)
		return (2*(n-1) == deg_sum);
	}
}
