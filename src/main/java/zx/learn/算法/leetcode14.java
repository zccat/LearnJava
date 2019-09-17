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

        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strings));


    }

    public static String longestCommonPrefix(String[] strs) {

        char[] first = strs[0].toCharArray();
        int len = first.length;
        int resLen = 0;
        for (String str : strs) {
            char[] chars = str.toCharArray();
            for (int i = 0; i < Math.min(len, str.length()); i++) {
                if (chars[i] == first[i]) {
                    if (i > resLen) {
                        resLen = i;
                    }
                } else {
                    break;
                }
            }
        }
        return strs[0].substring(0, resLen -1);
    }
}
