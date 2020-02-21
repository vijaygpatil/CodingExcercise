package com.selfPractice.DFS;

public class SumOfPathNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }

    public static int findSumOfPathNumbers(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    public static int findRootToLeafPathNumbers(TreeNode root, int pathSum) {
        if(root == null) {
            return 0;
        }

        pathSum = 10 * pathSum + root.val;

        if(root.left == null && root.right == null) {
            return pathSum;
        }

        return findRootToLeafPathNumbers(root.left, pathSum) + findRootToLeafPathNumbers(root.right, pathSum);
    }
}
