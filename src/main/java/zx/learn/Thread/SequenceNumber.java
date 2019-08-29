package zx.learn.Thread;

/**
 * Created with IntelliJ IDEA.
 * User: zx
 * Date: 2019/8/21
 * Time: 10:27
 * Description:
 */
public class SequenceNumber {


    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();

        TestClient c1 = new TestClient(sn);
        TestClient c2 = new TestClient(sn);
        TestClient c3 = new TestClient(sn);
        TestClient c4 = new TestClient(sn);

        c1.start();
        c2.start();
        c3.start();
        c4.start();

    }

    private static class TestClient extends Thread {

        private SequenceNumber sn;

        public TestClient( SequenceNumber sn) {
            this.sn = sn;
        }

        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("thread["+Thread.currentThread().getName()+"] sn["+sn.getNextNum()+"]");
            }
        }

    }



}
