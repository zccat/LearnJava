package zx.learn.并发;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/9/10
 * Time: 14:29
 * Description:
 */
public class CallerTask implements Callable<String> {
    @Override
    public String call() throws Exception {

        Thread.sleep(100);
        return "hello";

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();

        String res = futureTask.get();

        System.out.println(res);

    }
}
