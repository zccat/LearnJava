package zx.learn.算法;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/11
 * Time: 8:10
 * Description:
 */
public class leetcodeBiTree {


    public static void main(String[] args) {

        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println(countNodes(null));


    }

    public static int countNodes(TreeNode root) {

        int leftH = getLH(root);
        int rightH = getRH(root);

        if (leftH == rightH) {
            System.out.println("Node:" + root.val + " LeftH:" + leftH + " RightH:" + rightH);
            return (int) (Math.pow(2, leftH) - 1) * 2;
        }

        return countNodes(root.left) + countNodes(root.right);

//        if (root == null) {
//            return 0;
//        }
//        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private static int getRH(TreeNode root) {
        int result = 0;
        while (root != null) {
            result++;
            root = root.right;
        }
        return result;
    }

    private static int getLH(TreeNode root) {
        int result = 0;
        while (root != null) {
            result++;
            root = root.left;
        }
        return result;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}