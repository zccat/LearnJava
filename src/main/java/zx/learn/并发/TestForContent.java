package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 11:22
 * Description:
 */
public class TestForContent {

    static final int LINE_NUM = 2048;
    static final int COLUM_NUM = 2048;

    public static void main(String[] args) {

        long[][] array = new long[LINE_NUM][COLUM_NUM];

        Timer t = new Timer();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUM_NUM; j++) {
                array[i][j] = i * 2 + j;
            }
        }
        System.out.println( "先行后列时间："+t.duration());;

        Timer tt = new Timer();
        for (int i = 0; i < COLUM_NUM; i++) {
            for (int j = 0; j < LINE_NUM; j++) {
                array[j][i] = i * 2 + j;
            }
        }
        System.out.println( "先行后列时间："+tt.duration());;

    }

}
