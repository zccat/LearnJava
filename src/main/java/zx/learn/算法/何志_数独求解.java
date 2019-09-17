package zx.learn.算法;

import zx.learn.并发.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/6
 * Time: 14:56
 * Description:
 */
public class 何志_数独求解 {

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

        何志_数独求解 m = new 何志_数独求解();

        m.printBoard(board);

        Timer timer = new Timer();
        m.solveSudoku(board);
        System.out.println("耗时："+timer.duration());;

        m.printBoard(board);


    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean [][]rows = new boolean[9][10];
    boolean [][]rols = new boolean[9][10];
    boolean [][]grids = new boolean[9][10];
    boolean over =false;
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.') {
                    rows[i][ board[i][j] - '0' ] = true;
                    rols[j][ board[i][j] - '0'] = true;
                    grids[j / 3 + i / 3 * 3][board[i][j] - '0'] = true;
                }
            }
        }
        dfs(0 , 0, board);
        char [][]re = board;
    }

    private void dfs(int i, int j, char[][] board) {
        if(i == 9 && j == 0) {
            over = true;
            return;
        }
        if(board[i][j] == '.') {
            for (int num = 1; num <= 9; num++) {
                if (!rows[i][num] && !rols[j][num] && !grids[j / 3 + i / 3 * 3][num]) {
                    rows[i][num] = true;
                    rols[j][num] = true;
                    board[i][j] = (char) (num + '0');
                    grids[j / 3 + i / 3 * 3][num] = true;
                    if (j < 8)
                        dfs(i, j + 1, board);
                    else
                        dfs(i + 1, 0, board);
                    if(over)
                        return;
                    rows[i][num] = false;
                    rols[j][num] = false;
                    grids[j / 3 + i / 3 * 3][num] = false;
                    board[i][j] = '.';
                }
            }
        }else {
            if (j < 8)
                dfs(i, j + 1, board);
            else
                dfs(i + 1, 0, board);

        }
    }

}

