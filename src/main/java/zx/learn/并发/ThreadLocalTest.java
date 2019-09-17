package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/16
 * Time: 11:15
 * Description:
 */
public class ThreadLocalTest {

    public static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("thread a string value");

                System.out.println(stringThreadLocal.get());
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                stringThreadLocal.set("thread b string value");

                System.out.println(stringThreadLocal.get());
            }
        });

        a.start();
        b.start();

    }

}
