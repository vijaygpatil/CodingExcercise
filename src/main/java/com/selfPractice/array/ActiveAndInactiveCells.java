package com.selfPractice.array;

public class ActiveAndInactiveCells {
	// C++ program to count active and inactive cells after k
	// day

	// cells[] - store current status of cells
	// n - Number of cells
	// temp[] - to perform intermediate operations
	// k - number of days
	// active - count of active cells after k days
	// inactive - count of active cells after k days
	static void activeAndInactive(int cells[], int n, int k)
	{
		// copy cells[] array into temp [] array
		int[] temp = new int[n];
		for (int i=0; i<n ; i++)
			temp[i] = cells[i];

		// Iterate for k days
		while (k != 0)
		{
			// Finding next values for corner cells
			temp[0] = 0^cells[1];
			temp[n-1] = 0^cells[n-2];

			// Compute values of intermediate cells
			// If both cells active or inactive, then temp[i]=0
			// else temp[i] = 1.
			for (int i=1; i<=n-2; i++)
				temp[i] = cells[i-1] ^ cells[i+1];

			// Copy temp[] to cells[] for next iteration
			for (int i=0; i<n; i++)
				cells[i] = temp[i];
		}

		// count active and inactive cells
		int active = 0, inactive = 0;
		for (int i=0; i<n; i++){
			//(cells[i] == 1)? active++ : inactive++;
		}

		System.out.println("Active Cells = %d, Inactive Cells = %d" + active +""+ inactive);
		
		k--;
	}

	// Driver program to check the test case
	public static void main(String[] args)
	{
		int cells[] = {0, 1, 0, 1, 0, 1, 0, 1};
		int k = 3;
		int n = cells.length;
		activeAndInactive(cells, n, k);
	}

}
