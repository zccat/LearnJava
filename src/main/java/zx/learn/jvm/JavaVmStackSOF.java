package zx.learn.jvm;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/16
 * Time: 14:13
 * Description:
 */
public class JavaVmStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVmStackSOF oom = new JavaVmStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable throwable) {
            System.out.println("stack length:" + oom.stackLength);
            throw throwable;
        }
    }

}
