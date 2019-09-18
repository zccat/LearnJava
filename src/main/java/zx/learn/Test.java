package zx.learn;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Test {
    public static void main(String args[]) throws InterruptedException {
        Timer timer = new Timer();
        System.out.println(LocalDateTime.now());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("任務");
                System.out.println(LocalDateTime.now());
            }
        }, new Date(System.currentTimeMillis() + 2000));


        Thread.sleep(5000);
        System.out.println(LocalDateTime.now());
        timer.cancel();

    }

}