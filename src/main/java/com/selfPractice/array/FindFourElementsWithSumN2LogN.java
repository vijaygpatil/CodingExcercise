package com.selfPractice.array;

import java.util.Arrays;
import java.util.Comparator;

public class FindFourElementsWithSumN2LogN {

	private static class PairSumComparator implements Comparator<pairSum> {
		@Override
		public int compare(pairSum o1, pairSum o2) {
			return o1.sum - o2.sum;
		}
	}

	// Function to check if two given pairs have any common element or not
	static boolean noCommon(pairSum a, pairSum b) {
		if (a.first == b.first || a.first == b.sec || a.sec == b.first || a.sec == b.sec)
			return false;
		return true;
	}

	// The function finds four elements with given sum X
	static void findFourElements(int arr[], int n, int X) {
		int i, j;

		// Create an auxiliary array to store all pair sums
		int size = (n * (n - 1)) / 2;
		pairSum[] aux = new pairSum[size];

		/*
		 * Generate all possible pairs from A[] and store sums of all possible
		 * pairs in aux[]
		 */
		int k = 0;
		for (i = 0; i < n - 1; i++) {
			for (j = i + 1; j < n; j++) {
				aux[k].sum = arr[i] + arr[j];
				aux[k].first = i;
				aux[k].sec = j;
				k++;
			}
		}

		// Sort the aux[] array using library function for sorting
		Arrays.sort(aux, new PairSumComparator());

		// Now start two index variables from two corners of array
		// and move them toward each other.
		i = 0;
		j = size - 1;
		while (i < size && j >= 0) {
			if ((aux[i].sum + aux[j].sum == X) && noCommon(aux[i], aux[j])) {
				System.out.print(arr[aux[i].first] + ", " + arr[aux[i].sec] + ", " + arr[aux[j].first] + ", " + arr[aux[j].sec]);
				return;
			} else if (aux[i].sum + aux[j].sum < X)
				i++;
			else
				j--;
		}
	}

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 1, 2 };
		int n = arr.length;
		int X = 91;
		findFourElements(arr, n, X);
	}
}

class pairSum {
	int first; // index (int A[]) of first element in pair
	int sec; // index of second element in pair
	int sum; // sum of the pair

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSec() {
		return sec;
	}

	public void setSec(int sec) {
		this.sec = sec;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
};
