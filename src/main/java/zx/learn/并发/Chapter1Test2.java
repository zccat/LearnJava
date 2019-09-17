package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/10
 * Time: 9:37
 * Description:
 */
public class Chapter1Test2 {

    public static volatile Object resourceA = new Object();
    public static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get ResourceA lock");
                        synchronized (resourceB) {
                            System.out.println("threadA get ResourceB lock");

                            System.out.println("threadA release ResourceA lock");
                            resourceA.wait();

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println("threadB get ResourceA lock");
                        synchronized (resourceB) {
                            System.out.println("threadB get ResourceB lock");

                            System.out.println("threadB release ResourceA lock");
                            resourceA.wait();

                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        System.out.println("Main Over");
    }


}
