package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 9:10
 * Description:
 */
public class DaemonTest {

    public static void main(String[] args) {

        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (; ; ) {

                    }
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        });

//        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println("========Main is Over========");

    }

}
