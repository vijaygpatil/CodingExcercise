package com.selfPractice.misc;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ConnectNRopesWithMinimumCost {

	static int minCost(List<Integer> len, int n) {
		// Create a priority queue (
		// http://www.cplusplus.com/reference/queue/priority_queue/ )
		// By default 'less' is used which is for decreasing order
		// and 'greater' is used for increasing order
		// priority_queue<int, vector<int>, greater<int>> pq(arr, arr+n);

		Queue<Integer> pq = new PriorityQueue<>();
		pq.addAll(len);

		// Initialize result
		int res = 0;

		// While size of priority queue is more than 1
		while (pq.size() > 1) {
			// Extract shortest two ropes from pq
			int first = pq.peek();
			pq.remove();
			int second = pq.peek();
			pq.remove();

			// Connect the ropes: update result and
			// insert the new rope to pq
			res += first + second;
			pq.add(first + second);
		}

		return res;
	}

	// Driver program to test above function
	public static void main(String[] args) {
		Integer len[] = { 4, 3, 2, 6 };
		int size = len.length;
		System.out.println("Total cost for connecting ropes is " + minCost(Arrays.asList(len), size));
	}
}
