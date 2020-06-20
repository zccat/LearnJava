package zx.learn.并发;
import static java.util.concurrent.TimeUnit.*;

public class Timer {
  private long start = System.nanoTime();
  public long duration() {
//    NANOSECONDS.toMillis()
    return NANOSECONDS.toNanos(
      System.nanoTime() - start);
  }
  public static long duration(Runnable test) {
    Timer timer = new Timer();
    test.run();
    return timer.duration();
  }
}