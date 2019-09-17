package zx.learn.并发;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 10:07
 * Description:
 */
public class TestUnSafe {

    private static final Unsafe unsafe;

    private static final long stateOffset;

    private volatile long states = 0;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");

            field.setAccessible(true);

            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("states"));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            System.out.println("Msg:" + e.getLocalizedMessage());
//            e.printStackTrace();
            throw new Error(e);
        }
    }

    public static void main(String[] args) {

        TestUnSafe test = new TestUnSafe();
        boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);

    }


}
