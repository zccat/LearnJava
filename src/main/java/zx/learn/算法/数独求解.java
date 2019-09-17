package zx.learn.算法;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import zx.learn.并发.Timer;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/6
 * Time: 10:41
 * Description:
 */

@Slf4j
public class 数独求解 {


    public static void main(String[] args) {

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        数独求解 m = new 数独求解();

        m.printBoard(board);

        Timer timer = new Timer();
        m.solveSudoku(board);
        System.out.println("耗时："+timer.duration());;

        m.printBoard(board);

//        int[] res = new int[]{0, 0, 0, 0, 0, 0, 0, 7, 0, 0};

//        System.out.println(m.hasOnlyOnePossible(res));

    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void solveSudoku(char[][] board) {

        //行 列 可能的值(位置上的值为 0 ，则代表这个值被排除，否则，这个值可能填在这里
        int[][][] possibleValue = new int[9][9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 4 && j == 4) {
                    System.out.println();
                }
                if (board[i][j] != '.') {
//                    possibleValue[i][j] = null;
                } else {
                    for (int k = 0; k < 10; k++) {
                        possibleValue[i][j][k] = k;
                    }
                    possibleValue[i][j] = getPossibleValueForBox(i, j, board, possibleValue[i][j]);
                }
            }
        }



        while (!isJie(board)) {
            boolean flag = false;
            //开始遍历求解
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] != '.') {
                        continue;
                    }
                    if (i == 4 && j == 4) {
                        System.out.println();
                    }
                    int num = hasOnlyOnePossible(possibleValue[i][j]);
                    //该位置有解
                    if (num != 0) {
//                        log.info("位置" + i + "  " + j + "找到了解，是" + num);
                        board[i][j] = (char) ('0' + num);
                        tnvh(possibleValue, i, j, num);
                        flag = true;
                    }
                }
            }
            if (!flag) {
//                System.out.println("找不到解了！！");
                break;
            }
        }




//        for (int[][] ints : possibleValue) {
//            for (int[] anInt : ints) {
//                System.out.println(Arrays.toString(anInt));
//
//            }
//        }

    }

    public boolean isJie(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public void tnvh(int[][][] possibleValue, int row, int line, int res) {
        for (int k = 0; k < 9; k++) {
            possibleValue[row][k][res] = 0;
            possibleValue[k][line][res] = 0;
        }
        int startRow, startLine;
        startRow = row / 3 * 3;
        startLine = line / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                possibleValue[startRow + i][startLine + j][res] = 0;
            }
        }
    }

    public int hasOnlyOnePossible(int[] res) {
        if (res == null) {
            return 0;
        }
        boolean flag = false;
        int resAt = 0;
        for (int i = 1; i < 10; i++) {
            if (res[i] != 0) {
                if (resAt != 0) {
                    flag = true;
                }
                resAt = i;
            }
            if (flag) {
                return 0;
            }
        }
        return res[resAt];
    }

    private int[] getPossibleValueForBox(int row, int line, char[][] board, int[] res) {
        if (board[row][line] != '.') {
            return new int[10];
        }
//        res = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 行列 遍历
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.') {
                res[board[row][i] - '0'] = 0;
            }
            if (board[i][line] != '.') {
                res[board[i][line] - '0'] = 0;
            }
        }

        int startRow, startLine;
        startRow = row / 3 * 3;
        startLine = line / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startLine + j] == '.') {
                    continue;
                }
                res[board[startRow + i][startLine + j] - '0'] = 0;
            }
        }
        return res;
    }


}
