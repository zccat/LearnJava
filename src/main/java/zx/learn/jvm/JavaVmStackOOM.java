package zx.learn.jvm;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/16
 * Time: 14:13
 * Description:
 */
public class JavaVmStackOOM {


    private void dontStop(){
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();

    }

}
