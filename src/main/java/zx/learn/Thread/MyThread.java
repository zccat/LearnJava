package zx.learn.Thread;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/9 19:55
 * @Description:
 */
public class MyThread extends Thread {
    @Override
    public void run(){
        try{
            for(int i = 0 ; i <10;i++){
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
