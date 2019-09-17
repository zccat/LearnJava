package zx.learn.算法;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 15:28
 * Description:
 */
public class leetcode08 {

    public static void main(String[] args) {


        System.out.println(myAtoi("-dsafsa"));
    }

    public static int myAtoi(String str) {
        Long res;
        char[] chars = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            if(aChar == 0 || aChar ==' ')
                continue;
            if (aChar == '+' || aChar == '-') {

            }
            if (aChar >= '0' && aChar <= '9' ) {
                stringBuilder.append(aChar);
                res = Long.valueOf(stringBuilder.toString());

            } else {
                break;
            }
        }

        return 0;

    }


}
