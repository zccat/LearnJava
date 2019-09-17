package zx.learn.算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 15:28
 * Description:
 */
public class leetcode07 {

    public static void main(String[] args) {


        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public static int reverse(int x) {

        int max = 0x7fffffff;
        int min = 0x80000000;
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > max / 10 || (rev == max / 10 && pop > 7)) return 0;
            if (rev < min / 10 || (rev == min / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
