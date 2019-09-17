package zx.learn.并发.Chapter3;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 15:29
 * Description:
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));

        }
    }
}
