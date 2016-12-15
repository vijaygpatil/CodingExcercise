package com.selfPractice.binaryTree;

public class BinaryTreeHeight {
	BinaryTreeNode root;

	int maxDepth(BinaryTreeNode BinaryTreeNode) {
		if (BinaryTreeNode == null)
			return 0;
		else {
			int lDepth = maxDepth(BinaryTreeNode.left);
			int rDepth = maxDepth(BinaryTreeNode.right);
			return Math.max(lDepth, rDepth) + 1;
		}
	}

	public static void main(String[] args) {
		BinaryTreeHeight tree = new BinaryTreeHeight();
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.left.right = new BinaryTreeNode(5);
		System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
	}
}