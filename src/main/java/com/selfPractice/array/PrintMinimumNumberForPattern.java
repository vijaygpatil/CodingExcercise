package com.selfPractice.array;

import java.util.ArrayList;
import java.util.List;

public class PrintMinimumNumberForPattern {
	// Driver program to test above
	public static void main(String[] args) {
		printLeast("IDID");
		printLeast("I");
		printLeast("DD");
		printLeast("II");
		printLeast("DIDI");
		printLeast("IIDDD");
		printLeast("DDIDDIID");
	}

	// C++ program to print minimum number that can be formed
	// from a given sequence of Is and Ds
	static void printLeast(String arr) {
		// min_avail represents the minimum number which is
		// still available for inserting in the output vector.
		// pos_of_I keeps track of the most recent index
		// where 'I' was encountered w.r.t the output vector
		int min_avail = 1, pos_of_I = 0;

		// vector to store the output
		List<Integer> v = new ArrayList<>();

		// cover the base cases
		if (arr.charAt(0) == 'I') {
			v.add(1);
			v.add(2);
			min_avail = 3;
			pos_of_I = 1;
		} else {
			v.add(2);
			v.add(1);
			min_avail = 3;
			pos_of_I = 0;
		}

		// Traverse rest of the input
		for (int i = 1; i < arr.length(); i++) {
			if (arr.charAt(i) == 'I') {
				v.add(min_avail);
				min_avail++;
				pos_of_I = i + 1;
			} else {
				v.add(v.get(i));
				for (int j = pos_of_I; j <= i; j++) {
					int increment = v.get(j) + 1;
					v.add(j, increment);
				}

				min_avail++;
			}
		}

		// print the number
		for (int i = 0; i < v.size(); i++)
			System.out.print(v.get(i) + " ");
		System.out.println();
	}
}
