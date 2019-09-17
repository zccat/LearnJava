package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/10
 * Time: 9:44
 * Description:
 */
public class Chapter1WatiNotifyInterupt {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("======begin======");
                    synchronized (obj) {
                        obj.wait();
                    }
                    System.out.println("=======end=======");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        Thread.sleep(1000);
        System.out.println("======begin interrupt threadA======");
        threadA.interrupt();
        System.out.println("=======end interrupt threadA=======");
    }



}
