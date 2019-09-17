package zx.learn.算法;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/11
 * Time: 8:10
 * Description:
 */
public class leetcode13 {

    public static void main(String[] args) {

        romanToInt2("IV");


        for (int i = 0; i <= 3999; i++) {
            String s = intToRoman(i);
            int res = romanToInt2(s);
            System.out.println("Test:" + res + "==" + s);
            assert res == i;
        }

    }

    static int[] ints = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] strings = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static StringBuffer sb = new StringBuffer();

    public static String intToRoman(int num) {

        int index = 0;
        while (index < ints.length) {
            while (num >= ints[index]) {
                num -= ints[index];
                sb.append(strings[index]);
            }
            index++;
        }
        String result = sb.toString();
        sb.delete(0, result.length());
        return result;
    }

    public static int romanToInt(String s) {
        int index = 0;
        int result = 0;
        while (index < strings.length) {
            while (s.startsWith(strings[index])) {
                result += ints[index];
                s = s.substring(strings[index].length());
            }
            index++;
        }
        return result;
    }

    public static int romanToInt2(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'I':
                    result += 1;
                    break;
            }
        }

        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != 'C' && chars[i] != 'X' && chars[i] != 'I')
                continue;
            if (chars[i] == 'C' && (chars[i + 1] == 'M' || chars[i + 1] == 'D')) {
                result -= 200;
                continue;
            }
            if (chars[i] == 'X' && (chars[i + 1] == 'C' || chars[i + 1] == 'L')) {
                result -= 20;
                continue;
            }
            if (chars[i] == 'I' && (chars[i + 1] == 'X' || chars[i + 1] == 'V')) {
                result -= 2;
            }
        }

//        if (s.contains("CM"))
//            result -= 200;
//        if (s.contains("CD"))
//            result -= 200;
//        if (s.contains("XC"))
//            result -= 20;
//        if (s.contains("XL"))
//            result -= 20;
//        if (s.contains("IX"))
//            result -= 2;
//        if (s.contains("IV"))
//            result -= 2;

        return result;
    }
}
