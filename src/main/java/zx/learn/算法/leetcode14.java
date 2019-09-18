package zx.learn.算法;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/11
 * Time: 8:10
 * Description:
 */
public class leetcode14 {

    public static void main(String[] args) {

//        String[] strings = new String[]{"c","c"};
//        String[] strings = new String[]{"flower", "flow", "flight"};

        String[] strings = new String[]{"acc","a","ccc"};
        System.out.println(longestCommonPrefix(strings));


    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String first = strs[0];
        int resLen = first.length();
        int temp = 0;
        for (int i = 1; i < strs.length; i++) {
            temp = getSameLength(first, strs[i]);
            if (temp < resLen) {
                resLen = temp;
            }
        }

        return first.substring(0, resLen);
    }

    public static int getSameLength(String str, String other) {
        if (str == null || other == null) {
            return 0;
        }

        int res = 0;
        for (int i = 0; i < Math.min(str.length(), other.length()); i++) {
            if (str.charAt(i) == other.charAt(i)) {
                res = i + 1;
            }else
                break;
        }
        System.out.println(str + " and " + other + " same length " + res);

        return res;
    }
}
