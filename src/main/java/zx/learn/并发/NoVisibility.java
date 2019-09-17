package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/9
 * Time: 14:41
 * Description:
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;
    private static class ReaderThread extends Thread{
        public void run() {
            while (!ready) {
                Thread.yield();
                System.out.println("ready:" + ready + "  number" + number );
            }
            System.out.println(System.nanoTime());
            System.out.println(number);
        }
    }

    public static class ChangeThread extends Thread {
        public void run() {
            while (true) {
                number++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        new ChangeThread().start();

//        Thread.sleep(10);
        System.out.println("main:"+System.nanoTime());


        number = 42;
//        ready = true;
    }

}
