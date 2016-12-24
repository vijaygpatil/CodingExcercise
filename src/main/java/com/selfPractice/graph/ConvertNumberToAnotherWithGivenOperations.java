package com.selfPractice.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ConvertNumberToAnotherWithGivenOperations {
	// C++ program to find minimum number of steps needed
	// to covert a number x into y with two operations
	// allowed : (1) multiplication with 2 (2) subtraction
	// with 1.
	// A node of BFS traversal

	// Returns minimum number of operations
	// needed to covert x into y using BFS
	static int minOperations(int x, int y)
	{
		// To keep track of visited numbers
		// in BFS.
		Set<Integer> visit = new HashSet<>();

		// Create a queue and enqueue x into it.
		Queue<Node> q = new LinkedList<>();
		Node n = new Node(x, 0);
		q.add(n);


		// Do BFS starting from x
		while (!q.isEmpty())
		{
			// Remove an item from queue
			Node t = q.poll();

			// If the removed item is target
			// number y, return its level
			if (t.val == y)
				return t.level;

			// Mark dequeued number as visited
			visit.add(t.val);

			// If we can reach y in one more step
			if (t.val*2 == y || t.val-1 == y)
				return t.level+1;

			// Insert children of t if not visited
			// already
			if (!visit.contains(t.val*2))
			{
				n.val = t.val*2;
				n.level = t.level+1;
				q.add(n);
			}
			
			if (t.val-1>=0 && visit.contains(t.val-1))
			{
				n.val = t.val-1;
				n.level = t.level+1;
				q.add(n);
			}
		}
		return y;
	}

	// Driver code
	public static void main(String[] args)
	{
		int x = 4, y = 7;
		System.out.println(minOperations(x, y));
	}

}

class Node
{
	int val;
	int level;
	public Node(int val, int level) {
		super();
		this.val = val;
		this.level = level;
	}
};
