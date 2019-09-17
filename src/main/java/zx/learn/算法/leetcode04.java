package zx.learn.算法;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 15:28
 * Description:
 */
public class leetcode04 {

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 2};
//        int[] nums2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] nums1 = new int[]{1, 2};
//        int[] nums2 = new int[]{3};
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int k = nums1.length + nums2.length;
        int k1 = (k + 1) / 2;
        int k2 = (k + 2) / 2;
        double res1 = getKth(k1, 0, nums1.length, 0, nums2.length, nums1, nums2);
        double res2 = getKth(k2, 0, nums1.length, 0, nums2.length, nums1, nums2);
//        System.out.println("res1:" + res1 + "   res2:" + res2);
//        System.out.println("k1:" + k1 + "   k2:" + k2);
        return (res1 + res2) / 2.0;
    }

    private static double getKth(int k, int aStart, int aEnd, int bStart, int bEnd, int[] nums1, int[] nums2) {

        new Exception().printStackTrace();
        int len1 = aEnd - aStart;
        int len2 = bEnd - bStart;
        if (len1 > len2) {
            return getKth(k, bStart, bEnd, aStart, aEnd, nums2, nums1);
        }
        int index1 = Math.min(aEnd, k / 2 + aStart) - 1;
        int index2 = Math.min(bEnd, k / 2 + bStart) - 1;
        if (len1 == 0) return nums2[k + bStart - 1];
        if (k == 1) return Math.min(nums1[aStart], nums2[bStart]);
        if (nums1[index1] > nums2[index2]) {
            return getKth(k - (index2 - bStart + 1), aStart, aEnd, index2 + 1, bEnd, nums1, nums2);
        } else {
            return getKth(k - (index1 - aStart + 1), index1 + 1, aEnd, bStart, bEnd, nums1, nums2);
        }
    }

}
