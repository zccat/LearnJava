package zx.learn.并发;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/12
 * Time: 9:52
 * Description:
 */
public class ThreadNotSafeCount {
    private Long value;

    public void inc() {
        ++value;
    }

}
