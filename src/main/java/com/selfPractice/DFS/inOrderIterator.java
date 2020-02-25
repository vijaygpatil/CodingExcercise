package com.selfPractice.DFS;

import java.util.Stack;

public class inOrderIterator {
    class inorder_tree_iterator {
        Stack<TreeNode> stk = new Stack<TreeNode>();

        public inorder_tree_iterator(TreeNode root) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }

        public TreeNode getNext() {
            if(stk.isEmpty())
                return null;

            TreeNode rVal = stk.pop();
            TreeNode temp = rVal.right;
            while(temp!= null) {
                stk.push(temp);
                temp = temp.left;
            }

            return rVal;
        }
    }

    public void inorder_using_iterator(TreeNode root) {
        inorder_tree_iterator iter = new inorder_tree_iterator(root);
        while (iter.hasNext()) {
            System.out.print(iter.getNext().val + ", ");
        }
        System.out.println();
    }
}
