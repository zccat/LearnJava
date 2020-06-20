package zx.learn.算法;

import zx.learn.wrapper.C;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 15:28
 * Description:
 */
public class leetcode297 {

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
//            return Arrays.toString()
            return "";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return null;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode initTree(Integer[] xmxu, int index) {
        if (xmxu == null || index >= xmxu.length || xmxu[index] == null) {
            return null;
        }
        TreeNode node = new TreeNode(xmxu[index]);

        node.left = initTree(xmxu, ++index);
        node.right = initTree(xmxu, ++index);

        return node;
    }

    public static void main(String[] args) {


        Integer[] xmxu = {1, 2, 3, null, null, 4, 5};
        TreeNode n = initTree(xmxu, 0);

        System.out.println(Arrays.toString(xmxu));

        Codec codec = new Codec();

        String str = codec.serialize(n);
        System.out.println(str);


    }


}


