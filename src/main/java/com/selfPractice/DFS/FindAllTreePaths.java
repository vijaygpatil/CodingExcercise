package com.selfPractice.DFS;

import java.util.ArrayList;
import java.util.List;

public class FindAllTreePaths {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findAllPath(root, sum, currentPath, allPaths);
        return allPaths;
    }

    public static void findAllPath(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allpaths) {
        if(root == null) {
            return;
        }

        currentPath.add(root.val);

        if(root.val == sum && root.left == null && root.right == null) {
            allpaths.add(new ArrayList<Integer>(currentPath));
        } else {
            findAllPath(root.left, sum - root.val, currentPath, allpaths);
            findAllPath(root.right, sum - root.val, currentPath, allpaths);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    private static void findPathsRecursive(TreeNode currentNode, int sum, List<Integer> currentPath,
                                           List<List<Integer>> allPaths) {
        if (currentNode == null)
            return;

        // add the current node to the path
        currentPath.add(currentNode.val);

        // if the current node is a leaf and its value is equal to sum, save the current path
        if (currentNode.val == sum && currentNode.left == null && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            // traverse the left sub-tree
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            // traverse the right sub-tree
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }

        // remove the current node from the path to backtrack,
        // we need to remove the current node while we are going up the recursive call stack.
        currentPath.remove(currentPath.size() - 1);
    }
}
