//package zx.learn.并发.Chapter3;
//
//import org.apache.poi.ss.formula.functions.T;
//import zx.learn.并发.Timer;
//
///**
// * Created with IntelliJ IDEA.
// * User: zx
// * Date: 2019/9/18
// * Time: 16:49
// * Description:
// */
//public class TestNoShare {
//
//    @sun.misc.Contended
//    private static long a = 0;
//
//    @sun.misc.Contended
//    private static long b = 0;
//
//    public static void main(String[] args) throws InterruptedException {
//        Thread threada = new Thread(() -> {
//            for (int i = 0; i < Integer.MAX_VALUE; i++) {
//                a++;
//            }
//        });
//        Thread threadb = new Thread(() -> {
//            for (int i = 0; i < Integer.MAX_VALUE; i++) {
//                b++;
//            }
//        });
//
//        Timer timer = new Timer();
//        threada.start();
//        threadb.start();
//        threada.join();
//        threadb.join();
//        System.out.println(timer.duration());
//    }
//
//}
