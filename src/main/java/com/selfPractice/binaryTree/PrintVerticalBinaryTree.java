package com.selfPractice.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class for a tree node
class Tree1Node {

	// data members
	private int key;
	private Tree1Node left;
	private Tree1Node right;

	// Accessor methods
	public int key() {
		return key;
	}

	public Tree1Node left() {
		return left;
	}

	public Tree1Node right() {
		return right;
	}

	// Constructor
	public Tree1Node(int key) {
		this.key = key;
		left = null;
		right = null;
	}

	// Methods to set left and right subtrees
	public void setLeft(Tree1Node left) {
		this.left = left;
	}

	public void setRight(Tree1Node right) {
		this.right = right;
	}
}

// Class for a Binary Tree
class TreeClass {

	private Tree1Node root;

	// Constructors
	public TreeClass() {
		root = null;
	}

	public TreeClass(Tree1Node n) {
		root = n;
	}

	// Method to be called by the consumer classes like Main class
	public void VerticalPrintMain() {
		VerticalPrint(root);
	}

	// A wrapper over VerticalSumUtil()
	private void VerticalPrint(Tree1Node root) {

		// base case
		if (root == null) {
			return;
		}

		// Creates an empty hashMap hM
		HashMap<Integer, List<Integer>> hM = new HashMap<Integer, List<Integer>>();

		// Calls the VerticalSumUtil() to store the vertical sum values in hM
		VerticalPrintUtil(root, 0, hM);

		// Prints the values stored by VerticalSumUtil()
		if (hM != null) {
			for (Map.Entry<Integer, List<Integer>> entry : hM.entrySet()) {
				System.out.print(entry.getKey() + "=" + entry.getValue() + " ");
			}
			System.out.print("");
		}
	}

	// Traverses the tree in Inoorder form and builds a hashMap hM that contains
	// the vertical sum
	private void VerticalPrintUtil(Tree1Node root, int hD, HashMap<Integer, List<Integer>> hM) {
		// base case
		if (root == null) {
			return;
		}

		if (hM.get(hD) != null) {
			hM.get(hD).add(root.key());
		} else {
			List<Integer> l = new ArrayList<>();
			l.add(root.key());
			hM.put(hD, l);
		}

		// Store the values in hM for left subtree
		VerticalPrintUtil(root.left(), hD - 1, hM);

		// Store the values in hM for right subtree
		VerticalPrintUtil(root.right(), hD + 1, hM);
	}
}

// Driver class to test the verticalSum methods
public class PrintVerticalBinaryTree {

	public static void main(String[] args) {
		/*
		 * Create following Binary Tree 1 / \ 2 3 / \ / \ 4 5 6 7
		 * 
		 */
		Tree1Node root = new Tree1Node(1);
		root.setLeft(new Tree1Node(2));
		root.setRight(new Tree1Node(3));
		root.left().setLeft(new Tree1Node(4));
		root.left().setRight(new Tree1Node(5));
		root.right().setLeft(new Tree1Node(6));
		root.right().setRight(new Tree1Node(7));
		TreeClass t = new TreeClass(root);

		System.out.println("Following are the values of vertical sums with " + "the positions of the columns with respect to root ");
		t.VerticalPrintMain();
	}
}
