package zx.learn.并发;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/10
 * Time: 9:29
 * Description:
 */
public class Chapter1Test1 {

    private static final Queue<String> queue = new LinkedList<>();
    public static int i = 0;

    public static class CreaterThread extends Thread {
        public void run() {
            synchronized (queue) {
                while (queue.size() >= 100) {

                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }

                queue.add("Task" + i++);
                queue.notifyAll();
            }
        }
    }


    public static class UseThread extends Thread {
        public void run() {
            synchronized (queue) {
                while (queue.size() == 0) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                String s = queue.peek();
                System.out.println(s);
                queue.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        new CreaterThread().start();
        new UseThread().start();

    }

}
