package com.selfPractice.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BinaryDigitThatIsMultipleOfN {
	// C++ code to get the smallest multiple of N with
	// binary digits only.
	// Method return true if N has only 1s and 0s in its
	// decimal representation
	boolean isBinaryNum(int N)
	{
		while (N > 0)
		{
			int digit = N % 10;
			if (digit != 0 && digit != 1)
				return false;
			N /= 10;
		}
		return true;
	}

	// Method return t % N, where t is stored as
	// a string
	static int mod(String t, int N)
	{
		int r = 0;
		for (int i = 0; i < t.length(); i++)
		{
			r = r * 10 + (t.charAt(i) - '0');
			r %= N;
		}
		return r;
	}

	// method returns smallest multiple which has
	// binary digits
	static String getMinimumMultipleOfBinaryDigit(int N)
	{
		Queue<String> q = new LinkedList<>();
		Set<Integer> visit = new HashSet<>();

		String t = "1";

		// In starting push 1 into our queue
		q.add(t);

		// loop until queue is not empty
		while (!q.isEmpty())
		{
			// Take the front number from queue.
			t = q.poll();

			// Find remainder of t with respect to N.
			int rem = Integer.valueOf(t) % N;

			// if remainder is 0 then we have
			// found our solution
			if (rem == 0)
				return t;

			// If this remainder is not previously seen,
			// then push t0 and t1 in our queue
			else if(!visit.contains(rem))
			{
				visit.add(rem);
				q.add(t + "0");
				q.add(t + "1");
			}
		}
		return t;
	}

	// Driver code to test above methods
	public static void main(String[] args)
	{
		int N = 12;
		System.out.println(getMinimumMultipleOfBinaryDigit(N));
	}

}
