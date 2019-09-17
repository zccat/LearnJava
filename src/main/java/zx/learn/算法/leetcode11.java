package zx.learn.算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/11
 * Time: 8:10
 * Description:
 */
public class leetcode11 {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(doublePtrMethod(ints));

    }

    public static int doublePtrMethod(int[] height) {
        int left = 0, right = height.length - 1;
        int current;
        int ret = 0;
        while (left < right) {
            current = (right - left) * Math.min(height[left], height[right]);
            if (current > ret) {
                ret = current;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ret;
    }

    public static int maxArea(int[] height) {
        int[] sort = height.clone();
        Arrays.sort(sort);
        int res = 0;
        for (int i = sort.length - 1; i >= 0; i--) {
            int startIndex = -1;
            int endIndex = -1;
            for (int j = 0; j < height.length; j++) {
                if (height[j] >= sort[i]) {
                    startIndex = j;
                    break;
                }
            }
            for (int j = height.length - 1; j >= 0; j--) {
                if (height[j] >= sort[i]) {
                    endIndex = j;
                    break;
                }
            }
            if (startIndex != -1 && endIndex != -1) {
                int tempRes = Math.min(height[startIndex], height[endIndex]) * (endIndex - startIndex);
                if (tempRes > res) {
                    res = tempRes;
                }
                if (res / (sort[i] == 0 ? 1 : sort[i]) > height.length) {
                    return res;
                }
            }
        }
        return res;
    }

}
