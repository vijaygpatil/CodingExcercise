package com.selfPractice.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeIntervals {
	
	static class Interval {
		int start;
		int end;

		public Interval(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}
	}
	
	private static class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start < o2.start ? 1 : 0;
		}
	}
	
	public static void main(String[] args) {
		Interval[] arr = { new Interval( 6, 8 ), new Interval( 1, 9 ), new Interval( 2, 4 ), new Interval( 4, 7 ) };
		int n = arr.length;
		mergeIntervals(arr, n);
	}
	
	// The main function that takes a set of intervals, merges
	// overlapping intervals and prints the result
	private static void mergeIntervals(Interval[] arr, int n)
	{
		// Test if the given set has at least one interval
		if (n <= 0)
			return;

		// Create an empty stack of intervals
		Stack<Interval> s = new Stack<>();

		// sort the intervals in increasing order of start time
		Arrays.sort(arr, new IntervalComparator());

		// push the first interval to stack
		s.push(arr[0]);

		// Start from the next interval and merge if necessary
		for (int i = 1 ; i < n; i++)
		{
			// get interval from stack top
			Interval top = s.peek();

			// if current interval is not overlapping with stack top,
			// push it to the stack
			if (top.end < arr[i].start)
				s.push(arr[i]);

			// Otherwise update the ending time of top if ending of current
			// interval is more
			else if (top.end < arr[i].end)
			{
				top.end = arr[i].end;
				s.push(top);
			}
		}

		// Print contents of stack
		while (!s.empty())
		{
			Interval t = s.pop();
			System.out.println("[" + t.start + "," + t.end + "] ");
			s.pop();
		}
		return;
	}
}

