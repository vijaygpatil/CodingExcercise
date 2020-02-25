package com.selfPractice.DFS;

public class identicalTrees {
    public static boolean are_identical(
            TreeNode root1,
            TreeNode root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 != null && root2 != null) {
            return   ((root1.val == root2.val) &&
                    are_identical(root1.left, root2.left) &&
                    are_identical(root1.right, root2.right));
        }

        return false;
    }
}
