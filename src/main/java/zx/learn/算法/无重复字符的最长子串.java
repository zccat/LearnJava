package zx.learn.算法;


import zx.learn.并发.Timer;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/5
 * Time: 8:53
 * Description:
 */
public class 无重复字符的最长子串 {


    public static void main(String[] args) {


//        String s = "tmmzuxt";
//        String s = "abcabcbb";
//        String s = "dvdf";
        String s = " sjdhfjdsqgtriyjopfgjkhdskjgdghiodfgdkashgfjldzxcvbnmasdfghjkl";

        Timer timer = new Timer();
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(timer.duration());


    }


    public static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {

                //再开始窗口后遇到
                int sub = map.get(chars[i]);
                if (sub >= start) {
                    //记录找到的最大值
                    if (res < i - start) {
                        res = i - start;
                    }
                    //更改开始窗口
                    start = sub + 1;
                }
                //更新下标
                map.put(chars[i], i);

            } else {
                map.put(chars[i], i);
            }
        }
        return Math.max(chars.length - start, res);
    }
}
