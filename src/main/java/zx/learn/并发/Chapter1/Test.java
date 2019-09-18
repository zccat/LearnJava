package zx.learn.并发.Chapter1;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/18
 * Time: 15:37
 * Description:
 */
public class Test {
    public static void main(String[] args) {

        Thread t = new Thread(() -> {
            while (true) ;
        });

        // t.setDaemon(true);
        t.start();
        System.out.println("main is over");
    }
}
