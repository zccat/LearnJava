package zx.learn.并发.Chapter6;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;

public class TestMyLock {


    final static NoReentrantLock lock = new NoReentrantLock();

    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 10;

    final static AtomicInteger i = new AtomicInteger();


    public static void main(String[] args) {

        Thread producer = new Thread(() -> {

            lock.lock();
            try {
                while (queue.size() == queueSize) {
                    notEmpty.await();
                }

                queue.add("ele");
                i.addAndGet(1);

                notFull.signalAll();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        });


        Thread customer = new Thread(() -> {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    notFull.await();
                }

                String ele = queue.poll();
                System.out.println("消费了" + ele + "第" + i.get() + "次");

                notEmpty.signalAll();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }
        });


        producer.start();
        customer.start();


    }


}
