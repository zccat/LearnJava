package zx.learn.算法;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 15:28
 * Description:
 */
public class leetcode06 {

    public static void main(String[] args) {


        String s = "A";


        System.out.println(convert(s, 4));
    }

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int numLines = (s.length() + 2) / numRows * (numRows - 1) + 1;
//        int numLines = 100 ;
        char[][] res = new char[numRows][numLines];
        char[] chars = s.toCharArray();
        int line = 0, row = 0;
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (flag) {
                if (row == numRows) {
                    flag = false;
                    line++;
                    row = row - 2;
                    i--;
                } else {
                    System.out.println("Row:" + row + " Line:" + line + " = " + chars[i]);
                    res[row][line] = chars[i];
                    row++;
                }
            } else {
                if (row == -1) {
                    flag = true;
                    row = row + 2;
                    line--;
                    i--;
                } else {
                    System.out.println("Row:" + row + " Line:" + line + " = " + chars[i]);
                    res[row][line] = chars[i];
                    line++;
                    row--;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char[] re : res) {
            for (char c : re) {
//                System.out.print(c + "  ");
                if (c != 0)
                    stringBuilder.append(c);
            }
//            System.out.println();
        }


        return stringBuilder.toString();
    }
}
