package com.selfPractice.hash;

import java.util.HashMap;
import java.util.Map;

public class FindSubstringsWithEqualNumberOfZerosOneTwo {
	// C++ program to find substring with equal
	// number of 0's, 1's and 2's

	// Method to count number of substring which
	// has equal 0, 1 and 2
	public static int getSubstringWithEqual012(String str)
	{
		int n = str.length();

		// map to store, how many times a difference
		// pair has occurred previously
		Map<Pair, Integer> mp = new HashMap<>();
		Pair p = new Pair(0, 0);
		
		mp.put(p, 0);

		// zc (Count of zeroes), oc(Count of 1s)
		// and tc(count of twos)
		// In starting all counts are zero
		int zc = 0, oc = 0, tc = 0;

		// looping into string
		int res = 0; // Initialize result
		for (int i = 0; i < n; ++i)
		{
			// increasing the count of current character
			if (str.charAt(i) == '0') zc++;
			else if (str.charAt(i) == '1') oc++;
			else tc++; // Assuming that string doesn't contain
						// other characters

			// making pair of differences (z[i] - o[i],
			// z[i] - t[i])
			Pair tmp = new Pair(zc - oc, zc - tc);

			// Count of previous occurrences of above pair
			// indicates that the subarrays forming from
			// every previous occurrence to this occurrence
			// is a subarray with equal number of 0's, 1's
			// and 2's
			res = res + mp.get(tmp);

			// increasing the count of current difference
			// pair by 1
			int count = mp.get(tmp) + 1;
			mp.put(tmp, count);
		}

		return res;
	}

	// driver code to test above method
	public static void main(String[] args)
	{
		String str = "0102010";
		System.out.println(getSubstringWithEqual012(str));
	}
}

class Pair {
	int n;
	int m;
	
	public Pair(int n, int m) {
		this.n = n;
		this.m = m;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + m;
		result = prime * result + n;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (m != other.m)
			return false;
		if (n != other.n)
			return false;
		return true;
	}
}
