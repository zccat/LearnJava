package zx.learn.算法;

import java.util.*;
import java.util.concurrent.DelayQueue;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 15:28
 * Description:
 */
public class leetcode94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

//        Integer[] xmxu = {1, null, 2, 3};
        Integer[] xmxu = null;

        TreeNode n = initTree(xmxu, 0);


        List<Integer> res = inorderTraversal(n);

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

    // L P R
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        return merge(inorderTraversal(root.left), root.val, inorderTraversal(root.right));
    }

    public static List<Integer> merge(List<Integer> left, Integer node, List<Integer> right) {
        if (left == null) {
            left = new ArrayList<>();
        }
        if (node != null) {
            left.add(node);
        }
        if (right != null) {
            left.addAll(right);
        }
        return left;
    }


}
