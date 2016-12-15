package com.selfPractice.dynamic;

public class LongestLengthEvenSubStringSumOfLeftHalfRighHalfSame {
	// A O(n^2) time and O(1) extra space solution
	static int findLength(String str, int n) {
		int ans = 0; // Initialize result

		// Consider all possible midpoints one by one
		for (int i = 0; i <= n - 2; i++) {
			/*
			 * For current midpoint 'i', keep expanding substring on both sides,
			 * if sum of both sides becomes equal update ans
			 */
			int l = i, r = i + 1;

			/* initialize left and right sum */
			int lsum = 0, rsum = 0;

			/* move on both sides till indexes go out of bounds */
			while (r < n && l >= 0) {
				lsum += str.charAt(l) - '0';
				rsum += str.charAt(r) - '0';
				if (lsum == rsum)
					ans = Math.max(ans, r - l + 1);
				l--;
				r++;
			}
		}
		return ans;
	}

	public int findLength(char[] str) {
		int n = str.length;
		int maxlen = 0; // Initialize result

		// Choose starting point of every substring
		for (int i = 0; i < n; i++) {
			// Choose ending point of even length substring
			for (int j = i + 1; j < n; j += 2) {
				int length = j - i + 1;// Find length of current substr

				// Calculate left & right sums for current substr
				int leftsum = 0, rightsum = 0;
				for (int k = 0; k < length / 2; k++) {
					leftsum += (str[i + k] - '0');
					rightsum += (str[i + k + length / 2] - '0');
				}

				// Update result if needed
				if (leftsum == rightsum && maxlen < length)
					maxlen = length;
			}
		}
		return maxlen;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		String str = "123123";
		System.out.println("Length of the substring is " + findLength(str, str.length()));

		str = "1538023";
		System.out.println("Length of the substring is " + findLength(str, str.length()));
	}

}
