package zx.learn.并发.Chapter2;

public class Test {

    private static volatile long _longVal = 0;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            long val = 0;
            while (val < 100000) {
                _longVal++;
                val++;
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            long val = 0;
            while (val < 100000) {
                _longVal++;
                val++;
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("final val is: " + _longVal);
    }
}