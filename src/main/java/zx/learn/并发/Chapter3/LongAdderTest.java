package zx.learn.并发.Chapter3;

import zx.learn.wrapper.A;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 16:59
 * Description:
 */
public class LongAdderTest {

    static LongAdder adder = new LongAdder();

    static volatile boolean finish = false;


    static class ThreadAdd extends Thread {
        public void run() {
            for (int i = 0; i < 1000_0000; i++) {
//                System.out.println("ThreadA add 1");
                adder.add(1);
                if (ThreadLocalRandom.current().nextBoolean()) {
                    Thread.yield();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {

        ThreadAdd threadAdd = new ThreadAdd();

        Thread a = new Thread(threadAdd);
        Thread b = new Thread(threadAdd);
        Thread c = new Thread(threadAdd);
        Thread d = new Thread(threadAdd);
        Thread e = new Thread(threadAdd);
        Thread f = new Thread(threadAdd);
        Thread g = new Thread(threadAdd);
        Thread h = new Thread(threadAdd);


        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
        f.start();
        g.start();
        h.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!finish) {
                    System.out.println(adder.sum());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();

        a.join();
        b.join();
        c.join();
        d.join();
        e.join();
        f.join();
        g.join();
        h.join();

        finish = true;

        System.out.println(adder.sum());
        System.out.println("Main Over");

    }

}
