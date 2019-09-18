package zx.learn.算法;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/11
 * Time: 8:10
 * Description:
 */
public class leetcode15 {

    public static void main(String[] args) {
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        int[] nums = new int[]{3, 0, -2, -1, 1, 2};
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
//        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println(threeSum(nums));

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {

            left = 0;
            right = nums.length - 1;

            while (true) {

                int temp = nums[left] + nums[i] + nums[right];

                if (right <= i || left >= i) {
                    break;
                }

                if (temp > 0) {
                    right--;
//                    while (nums[right + 1] == nums[right]) {
//                        right--;
//                    }
                }
                if (temp < 0) {
                    left++;
//                    while (nums[left - 1] == nums[left]) {
//                        left++;
//                    }
                }

                if (temp == 0) {
                    List<Integer> integers = new ArrayList<>(Arrays.asList(nums[left], nums[i], nums[right]));
                    integers.sort(Integer::compareTo);
                    result.add(integers);
                    right--;
                    left++;
                    if (nums[left] == nums[right]) {
                        break;
                    }
                }

            }
        }
        return new ArrayList<>(result);
    }
}