package com.selfPractice.binaryTree;

public class BinaryTreeHeightZ {
	BinaryTreeNodeZ root;

	int maxDepth(BinaryTreeNodeZ BinaryTreeNode) {
		if (BinaryTreeNode == null)
			return 0;
		else {
			int lDepth = maxDepth(BinaryTreeNode.left);
			int rDepth = maxDepth(BinaryTreeNode.right);
			return Math.max(lDepth, rDepth) + 1;
		}
	}

	public static void main(String[] args) {
		BinaryTreeHeightZ tree = new BinaryTreeHeightZ();
		tree.root = new BinaryTreeNodeZ(1);
		tree.root.left = new BinaryTreeNodeZ(2);
		tree.root.right = new BinaryTreeNodeZ(3);
		tree.root.left.left = new BinaryTreeNodeZ(4);
		tree.root.left.right = new BinaryTreeNodeZ(5);
		System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
	}
}