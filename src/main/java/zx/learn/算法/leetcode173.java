package zx.learn.算法;

import org.apache.poi.ss.formula.functions.T;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class leetcode173 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }


        static TreeNode initTree(Integer[] integers) {

            TreeNode root = new TreeNode(7);
            root.left = new TreeNode(3);
            root.right = new TreeNode(15);
            root.right.left = new TreeNode(9);
            root.right.right = new TreeNode(20);
            return root;
        }
    }


    static class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();

            //将
            this._leftmostInorder(root);
        }


        //将自己和左孩子进行递归（进栈）
        private void _leftmostInorder(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            if (node.right != null) {
                this._leftmostInorder(node.right);
            }
            return node.val;
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !this.stack.empty();
        }
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.initTree(new Integer[]{1, 2, 3, null, 5, null, null, null, 8});
        BSTIterator iterator = new BSTIterator(tree);
        assert 3 == iterator.next();    // 返回 3
        assert 7 == iterator.next();    // 返回 7
        assert iterator.hasNext();      // 返回 true
        assert 9 == iterator.next();    // 返回 9
        assert iterator.hasNext();      // 返回 true
        assert 15 == iterator.next();   // 返回 15
        assert iterator.hasNext();      // 返回 true
        assert 20 == iterator.next();   // 返回 20
        assert !iterator.hasNext() : "错误"; // 返回 false
    }
}
