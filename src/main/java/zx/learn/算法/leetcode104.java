package zx.learn.算法;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: huzhixin
 * Date: 2020/11/5
 * Description: No Description
 */
public class leetcode104 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    static class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null)
                return 0;
            return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode tree = initTree(new Integer[]{3, 9, 20, null, null, 15, 7},0);
        System.out.println(tree);
        Solution solution = new Solution();
        int i = solution.maxDepth(tree);
        System.out.println(i);
    }

    public static TreeNode initTree(Integer[] xmxu, int index) {
        if ( xmxu == null || index >= xmxu.length || xmxu[index] == null) {
            return null;
        }
        TreeNode node = new TreeNode(xmxu[index]);

        node.left = initTree(xmxu, ++index);
        node.right = initTree(xmxu, ++index);

        return node;
    }



}
