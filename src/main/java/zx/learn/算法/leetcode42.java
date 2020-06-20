package zx.learn.算法;

public class leetcode42 {

    static class Solution {
        public int trap(int[] height) {
            int left = 0, right = 0;
            int temp = 0;
            int sum = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] >= left) {
                    left = height[i];
                    sum += temp;
                    temp = 0;
                }
                if (left > height[i]) {
                    temp += left - height[i];
                }
            }

            System.out.println("从左到右之后的sum：" + sum);
            temp = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                if (height[i] > right) {
                    right = height[i];
                    sum += temp;
                    temp = 0;
                }
                if (left > height[i]) {
                    temp += right - height[i];
                }
            }
            return sum;

        }
    }

    public static void main(String[] args) {
//        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] ints = {2, 0, 2};
        Solution solution = new Solution();
        int trap = solution.trap(ints);
        System.out.println(trap);

    }

}
