package com.selfPractice.DFS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MaximumSumPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = MaximumSumPath.findMaxSumPaths(root);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

    public static List<List<Integer>> findMaxSumPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findMaxSumPathsRecursion(root, 0, currentPath, result);
        return result;
    }

    public static void findMaxSumPathsRecursion(TreeNode root, int total, List<Integer> currentPath, List<List<Integer>> result) {
        if(root == null) {
            return;
        }

        currentPath.add(root.val);

        if(root.left == null && root.right == null) {
            result.add(new ArrayList<>(currentPath));
        } else {
            findMaxSumPathsRecursion(root.left, total + root.val, currentPath, result);
            findMaxSumPathsRecursion(root.right, total + root.val, currentPath, result);
        }

        currentPath.remove(currentPath.size() - 1);
    }
}
