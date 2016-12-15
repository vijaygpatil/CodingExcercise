package com.selfPractice.binaryTree;

public class BreadthFirstSearch {

	BinaryTreeNode root;

	public BreadthFirstSearch() {
		root = null;
	}

	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	int height(BinaryTreeNode root) {
		if (root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			return Math.max(lheight, rheight) + 1;
		}
	}

	void printGivenLevel(BinaryTreeNode root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	public static void main(String args[]) {
		BreadthFirstSearch tree = new BreadthFirstSearch();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}
}