package zx.learn.并发;


/**
 * CPU 的 cache的测试
 */
public class CacheTest {


    public static void main(String[] args) {


        int row = 1024;
        int col = 512;
        int[][] matrix = new int[row][col];
        //逐行遍历
        long startTime = System.nanoTime();
        int sum_row = 0;
        for (int _r = 0; _r < row; _r++) {
            for (int _c = 0; _c < col; _c++) {
                sum_row += matrix[_r][_c];
            }
        }
        long endTime = System.nanoTime();

        System.out.println("逐行遍历"+(endTime - startTime)+"ns");

        long startTime1 = System.nanoTime();

        //逐列遍历
        int sum_col = 0;
        for (int _c = 0; _c < col; _c++) {
            for (int _r = 0; _r < row; _r++) {
                sum_col += matrix[_r][_c];
            }
        }
        long endTime1 = System.nanoTime();

        System.out.println("逐列遍历"+(endTime1 - startTime1)+"ns");



//        int LEN = 64 * 1024 ;
//        int[] memory = new int[LEN];
//
//        int size = 0;
//        int increment = 0;
//
//        Map<Integer, Map<Integer, Long>> map = new HashMap<>();
//
//
//        //横行 表示访问几次
//        for (size = 1; size <= 18; size++) {
//            //纵列 表示一次条多少访问
//            Map mm = new HashMap<>();
//            map.put(size, mm);
//            for (increment = 1; increment <= 1024; increment *= 2) {
//                long startTime = System.nanoTime();
//                //访问10000000次，从而获取总时间
//                for (int i = 0; i < 10000000; i++) {
//                    for (int j = 0; j < size; j += increment) {
//                        memory[j] += j;
//                    }
//                }
//                long endTime = System.nanoTime();
//                long time = endTime - startTime;
//                time /= 1000;
//                mm.put(increment,time);
//
//            }
//
//        }
//
//        System.out.print("1  2  4   8   16   32   64   128   256   512   1024\n");
//        for (Integer row : map.keySet()) {
//            System.out.print(row + "  ");
//            Map<Integer, Long> mm = map.get(row);
//            for (Integer line : mm.keySet()) {
//                System.out.print(mm.get(line) + "  |  ");
//            }
//            System.out.println();
//        }


    }


}
