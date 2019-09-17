package zx.learn.并发.Chapter3;

import zx.learn.并发.Timer;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 17:27
 * Description:
 */
public class TestCPU {

    public static void main(String[] args) {
        long a = 0;
        Timer timer = new Timer();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            a++;
        }
        assert a == Integer.MAX_VALUE;
        System.out.println(timer.duration() + "ms");

    }
}
