package com.selfPractice.String;

public class IsInterleaved {
	// C/C++ program to check if given string is an interleaving
	// of the other two strings

	// Returns true if C is an interleaving of A and B,
	// otherwise returns false
	private static boolean isInterleaved (char[] A, char[] B, char[] C)
	{
		int n = C.length;
		
		// If A or B still have some characters, then length of
		// C is smaller than sum of lengths of A and B, so 
		// return false
		if (A.length >= n || B.length >= n)
			return false;
				
		int i = 0;
		int j = 0;
		int k = 0;
		
		// Iterate through all characters of C.
		while (i != n)
		{
			// Match first character of C with first character
			// of A. If matches them move A to next 
			if (A[j] == C[i])
				j++;

			// Else Match first character of C with first 
			// character of B. If matches them move B to next 
			else if (B[k] == C[i])
				k++;

			// If doesn't match with either A or B, then return
			// false
			else
				return false;
			
			// Move C to next for next iteration
			i++;
		}

		

		return true;
	}

	// Driver program to test above functions
	public static void main(String[] args)
	{
		char[] A = "AB".toCharArray();
		char[] B = "CD".toCharArray();
		char[] C = "ACBD".toCharArray();
		if (isInterleaved(A, B, C) == true)
			System.out.println("%s is interleaved of %s and %s");
		else
			System.out.println("%s is not interleaved of %s and %s");
	}

}
