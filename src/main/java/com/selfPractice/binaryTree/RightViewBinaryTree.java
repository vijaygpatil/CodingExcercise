package com.selfPractice.binaryTree;

class Max_level {
	int max_level;
}

public class RightViewBinaryTree {

	BinaryTreeNode root;
	Max_level max = new Max_level();

	// Recursive function to print right view of a binary tree.
	void rightViewUtil(BinaryTreeNode node, int level, Max_level max_level) {
		// Base Case
		if (node == null)
			return;

		// If this is the last Node of its level
		if (max_level.max_level < level) {
			System.out.print(node.data + " ");
			max_level.max_level = level;
		}

		// Recur for right subtree first, then left subtree
		rightViewUtil(node.right, level + 1, max_level);
		rightViewUtil(node.left, level + 1, max_level);
	}

	void rightView() {
		rightView(root);
	}

	void rightView(BinaryTreeNode node) {
		rightViewUtil(node, 1, max);
	}

	public static void main(String args[]) {
		RightViewBinaryTree tree = new RightViewBinaryTree();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);
		tree.root.right.left = new BinaryTreeNode(6);
		tree.root.right.right = new BinaryTreeNode(7);
		tree.root.right.left.right = new BinaryTreeNode(8);
		tree.rightView();
	}
}
