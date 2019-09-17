package zx.learn.算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 15:28
 * Description:
 */
public class leetcode05 {

    public static void main(String[] args) {
        String s = "aa";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        int resL = 0, resR = 0;
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int[] res = expandAroundCenter(chars, i);
            if (length < res[1] - res[0] - 1) {
                resL = res[0];
                resR = res[1];
                length = res[1] - res[0] - 1;
            }
//            System.out.println(length);
        }
        return s.substring(resL + 1, resL + 1 + length);
    }

    public static int[] expandAroundCenter(char[] chars, int c) {
        int[] res = new int[2];
        int resLength;
        int L = c, R = c;
        while (L >= 0 && R < chars.length && chars[L] == chars[R]) {
            L--;
            R++;
        }
        resLength = R - L - 1;
        res[0] = L;
        res[1] = R;
        L = c;
        R = c + 1;
        while (L >= 0 && R < chars.length && chars[L] == chars[R]) {
            L--;
            R++;
        }
        if (resLength < R - L - 1) {
            res[0] = L;
            res[1] = R;
        }
        return res;
    }
}
