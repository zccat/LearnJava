package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 11:12
 * Description:
 */
public class ReadThread extends Thread {


    public void run() {

        while (!Thread.currentThread().isInterrupted()) {
            if (ready) {
                System.out.println(num + num);
            }
            System.out.println("read thread.....");
        }

    }

    public static class WriteThread extends Thread {
        public void run() {
            num = 2;
            ready = true;
        }
    }

    private static int num = 0;
    private static boolean ready = false;

    public static void main(String[] args) throws InterruptedException {

        ReadThread readThread = new ReadThread();
        readThread.start();

        WriteThread writeThread = new WriteThread();
        writeThread.start();

        Thread.sleep(10);

        readThread.interrupt();

        System.out.println("main exit");


    }




}
