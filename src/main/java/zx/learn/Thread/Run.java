package zx.learn.Thread;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/9 19:56
 * @Description:
 */
public class Run {
    public static void main(String[] args) {
//        MyThread myThread = new MyThread();
//        zx.learn.Thread thread = new zx.learn.Thread(myThread,"test");
//        thread.start();

        ShareNumThread myThread = new ShareNumThread();
        Thread a = new Thread(myThread,"A");
        Thread b = new Thread(myThread,"B");
        Thread c = new Thread(myThread,"C");
        Thread d = new Thread(myThread,"D");
        Thread e = new Thread(myThread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();


        System.out.println("运行结束！");

    }
}
