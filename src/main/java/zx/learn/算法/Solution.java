package zx.learn.算法;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] res = solution.twoSum(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(res));

    }


    public int[] twoSum(int[] nums, int target) {

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int aim = target - num;
            if (set.contains(num)) {

                if (num == aim) {
                    List<Integer> integers = indexOf(nums, aim);
                    if (integers.size() >= 2) {
                        return new int[]{integers.get(0), integers.get(1)};
                    }
                    continue;
                }
                if (set.contains(aim)) {
                    return new int[]{indexOf(nums, num).get(0), indexOf(nums, aim).get(0)};
                }
            }
        }
        return null;
    }

    public List<Integer> indexOf(int[] nums, int target) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                integers.add(i);
            }
        }
        return integers;
    }


}