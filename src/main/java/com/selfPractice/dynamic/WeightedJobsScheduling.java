package com.selfPractice.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobsScheduling {

	// Find the latest job (in sorted array) that doesn't
	// conflict with the job[i]. If there is no compatible job,
	// then it returns -1.
	static int latestNonConflict(Job arr[], int i) {
		for (int j = i - 1; j >= 0; j--) {
			if (arr[j].finish <= arr[i - 1].start)
				return j;
		}
		return -1;
	}

	// A recursive function that returns the maximum possible
	// profit from given array of jobs. The array of jobs must
	// be sorted according to finish time.
	static int findMaxProfitRec(Job arr[], int n) {
		// Base case
		if (n == 1)
			return arr[n - 1].profit;

		// Find profit when current job is included
		int inclProf = arr[n - 1].profit;
		int i = latestNonConflict(arr, n);
		if (i != -1)
			inclProf += findMaxProfitRec(arr, i + 1);

		// Find profit when current job is excluded
		int exclProf = findMaxProfitRec(arr, n - 1);

		return Math.max(inclProf, exclProf);
	}

	// The main function that returns the maximum possible
	// profit from given array of jobs
	static int findMaxProfit(Job arr[], int n) {
		// Sort jobs according to finish time
		Arrays.sort(arr, new JobComparator());
		return findMaxProfitRec(arr, n);
	}

	// Driver program
	public static void main(String[] args) {
		Job[] arr = { new Job(3, 10, 20), new Job(1, 2, 50), new Job(6, 19, 100), new Job(2, 100, 200) };
		int n = arr.length;
		System.out.println("The optimal profit is " + findMaxProfit(arr, n));
	}
}

// C++ program for weighted job scheduling using Naive Recursive Method
// A job has start time, finish time and profit.
class Job {
	int start, finish, profit;

	public Job(int start, int finish, int profit) {
		super();
		this.start = start;
		this.finish = finish;
		this.profit = profit;
	}
}

// A utility function that is used for sorting events
// according to finish time
class JobComparator implements Comparator<Job> {
	@Override
	public int compare(Job o1, Job o2) {
		return o1.finish - o2.finish;
	}
}
