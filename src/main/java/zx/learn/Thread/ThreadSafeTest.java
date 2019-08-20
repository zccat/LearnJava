package zx.learn.Thread;

import net.jcip.annotations.GuardedBy;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.runner.notification.RunListener;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/12
 * Time: 11:13
 * Description:
 */

public class ThreadSafeTest {

    private int a = 0;
   @GuardedBy("this")  private static int b = 0;

    private void addB() {
        synchronized (this){
            b++;
        }

    }


    private synchronized void addA() {
        a++;
    }


    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();
        ThreadSafeTest threadSafeTest = new ThreadSafeTest();

        Thread r = new Thread(() -> {
            while (threadSafeTest.a < 10000000) {

                threadSafeTest.addA();
                threadSafeTest.addB();

            }
        });


        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(r);
        Thread thread4 = new Thread(r);
        Thread thread5 = new Thread(r);
        Thread thread6 = new Thread(r);
        r.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();


        while (threadSafeTest.a < 10000000) {
            Thread.sleep(100);
            System.out.println("a= " + threadSafeTest.a);
            System.out.println("b= " + b);
        }

    }

}
