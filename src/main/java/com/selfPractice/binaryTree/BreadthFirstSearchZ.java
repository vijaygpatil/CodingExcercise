package com.selfPractice.binaryTree;

public class BreadthFirstSearchZ {

	BinaryTreeNodeZ root;

	public BreadthFirstSearchZ() {
		root = null;
	}

	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	int height(BinaryTreeNodeZ root) {
		if (root == null)
			return 0;
		else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			return Math.max(lheight, rheight) + 1;
		}
	}

	void printGivenLevel(BinaryTreeNodeZ root, int level) {
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
		BreadthFirstSearchZ tree = new BreadthFirstSearchZ();
		tree.root = new BinaryTreeNodeZ(1);
		tree.root.left = new BinaryTreeNodeZ(2);
		tree.root.right = new BinaryTreeNodeZ(3);
		tree.root.left.left = new BinaryTreeNodeZ(4);
		tree.root.left.right = new BinaryTreeNodeZ(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}
}