package zx.learn.Thread;

/**
 * @Auther: 胡志新
 * @Date: 2019/4/9 20:08
 * @Description:
 */
public class ShareNumThread extends Thread{
    private int count = 5;
    @Override
    public void run(){
        super.run();
        count--;
        System.out.println("由 "+this.currentThread().getName()+"计算, count = "+count );
    }
}
