package com.selfPractice.array;

public class EquilibriumIndex {
	int equilibrium(int arr[], int n) {
		int i, j;
		int leftsum, rightsum;

		/*
		 * Check for indexes one by one until an equilibrium index is found
		 */
		for (i = 0; i < n; ++i) {
			leftsum = 0; // initialize left sum for current index i
			rightsum = 0; // initialize right sum for current index i

			/* get left sum */
			for (j = 0; j < i; j++)
				leftsum += arr[j];

			/* get right sum */
			for (j = i + 1; j < n; j++)
				rightsum += arr[j];

			/* if leftsum and rightsum are same, then we are done */
			if (leftsum == rightsum)
				return i;
		}

		/* return -1 if no equilibrium index is found */
		return -1;
	}

	public static void main(String[] args) {
		EquilibriumIndex equi = new EquilibriumIndex();
		int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
		int arr_size = arr.length;
		System.out.println(equi.equilibrium(arr, arr_size));
	}
}

// This code has been contributed by Mayank Jaiswal
