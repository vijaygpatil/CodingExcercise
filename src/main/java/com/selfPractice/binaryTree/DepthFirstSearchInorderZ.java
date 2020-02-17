package com.selfPractice.binaryTree;

import java.util.Stack;

public class DepthFirstSearchInorderZ {
	public void DFS(NodeDFS root) {
		Stack<NodeDFS> s = new Stack<NodeDFS>();
		s.add(root);
		while (s.isEmpty() == false) {
			NodeDFS x = s.pop();
			if (x.right != null)
				s.add(x.right);
			if (x.left != null)
				s.add(x.left);
			System.out.print(" " + x.data);
		}
	}

	static void inOrder(NodeDFS node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.printf("%s ", node.data);
		inOrder(node.right);
	}

	public static void main(String args[]) {
		NodeDFS root = new NodeDFS(1);
		root.left = new NodeDFS(2);
		root.left.left = new NodeDFS(4);
		root.left.right = new NodeDFS(5);
		root.right = new NodeDFS(3);
		root.right.left = new NodeDFS(6);
		root.right.right = new NodeDFS(7);

		DepthFirstSearchInorderZ b = new DepthFirstSearchInorderZ();
		System.out.println("Depth-First-Search : ");
		b.DFS(root);
	}
}

class NodeDFS {
	int data;
	NodeDFS left;
	NodeDFS right;

	public NodeDFS(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
