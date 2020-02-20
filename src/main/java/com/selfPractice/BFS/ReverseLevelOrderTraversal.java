package com.selfPractice.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrderTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if(root != null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                list.add(currentNode.val);
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
            }
            result.add(0, list);
        }
        return result;
    }

    public static List<List<Integer>> traverse1(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root != null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // add the node to the current level
                currentLevel.add(currentNode.val);
                // insert the children of current node to the queue
                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            // append the current level at the beginning
            result.add(0, currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(12);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(9);
        root1.right.left = new TreeNode(10);
        root1.right.right = new TreeNode(5);
        List<List<Integer>> result = ReverseLevelOrderTraversal.traverse1(root1);
        System.out.println("Reverse level order traversal: " + result);
    }
}
