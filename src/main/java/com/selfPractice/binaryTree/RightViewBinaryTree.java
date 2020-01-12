package com.selfPractice.binaryTree;

class Max_level {
	int max_level;
}

public class RightViewBinaryTree {

	BinaryTreeNodeZ root;
	Max_level max = new Max_level();

	// Recursive function to print right view of a binary tree.
	void rightViewUtil(BinaryTreeNodeZ node, int level, Max_level max_level) {
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

	void rightView(BinaryTreeNodeZ node) {
		rightViewUtil(node, 1, max);
	}

	public static void main(String args[]) {
		RightViewBinaryTree tree = new RightViewBinaryTree();
		tree.root = new BinaryTreeNodeZ(1);
		tree.root.left = new BinaryTreeNodeZ(2);
		tree.root.right = new BinaryTreeNodeZ(3);
		tree.root.left.left = new BinaryTreeNodeZ(4);
		tree.root.left.right = new BinaryTreeNodeZ(5);
		tree.root.right.left = new BinaryTreeNodeZ(6);
		tree.root.right.right = new BinaryTreeNodeZ(7);
		tree.root.right.left.right = new BinaryTreeNodeZ(8);
		tree.rightView();
	}
}
