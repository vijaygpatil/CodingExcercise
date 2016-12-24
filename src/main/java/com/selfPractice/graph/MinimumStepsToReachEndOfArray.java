package com.selfPractice.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class MinimumStepsToReachEndOfArray {
	// C++ program to find minimum jumps to reach end
	// of array

	// Method returns minimum step to reach end of array
	static int getMinStepToReachEnd(int arr[], int N) {
		// visit boolean array checks whether current index
		// is previously visited
		boolean[] visit = new boolean[N];

		// distance array stores distance of current
		// index from starting index
		int[] distance = new int[N];

		// digit vector stores indicies where a
		// particular number resides
		Vector<Vector<Integer>> digit = new Vector<>();

		// In starting all index are unvisited
		// storing indices of each number in digit vector
		for (int i = 1; i < N; i++) {
			Vector<Integer> vec = null;
			if (digit.get(arr[i]) != null) {
				vec = digit.get(arr[i]);
				vec.add(i);
			} else {
				vec = new Vector<>();
				vec.add(i);
			}
			digit.add(arr[i], vec);
		}

		// for starting index distance will be zero
		distance[0] = 0;
		visit[0] = true;

		// Creating a queue and inserting index 0.
		Queue<Integer> q = new LinkedList<>();
		q.add(0);

		// loop until queue in not empty
		while (!q.isEmpty()) {
			// Get an item from queue, q.
			int idx = q.poll();

			// If we reached to last index break from loop
			if (idx == N - 1)
				break;

			// Find value of dequeued index
			int d = arr[idx];

			// looping for all indices with value as d.
			for (int i = 0; i < digit.get(d).size(); i++) {
				int nextidx = digit.get(d).get(i);
				if (!visit[nextidx]) {
					visit[nextidx] = true;
					q.add(nextidx);

					// update the distance of this nextidx
					distance[nextidx] = distance[idx] + 1;
				}
			}

			// clear all indices for digit d, because all
			// of them are processed
			digit.get(d).clear();

			// checking condition for previous index
			if (idx - 1 >= 0 && !visit[idx - 1]) {
				visit[idx - 1] = true;
				q.add(idx - 1);
				distance[idx - 1] = distance[idx] + 1;
			}

			// checking condition for next index
			if (idx + 1 < N && !visit[idx + 1]) {
				visit[idx + 1] = true;
				q.add(idx + 1);
				distance[idx + 1] = distance[idx] + 1;
			}
		}

		// N-1th position has the final result
		return distance[N - 1];
	}

	// driver code to test above methods
	public static void main(String[] args) {
		int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 5, 4, 3, 6, 0, 1, 2, 3, 4, 5, 7 };
		int N = arr.length;
		System.out.println(getMinStepToReachEnd(arr, N));
	}

}
