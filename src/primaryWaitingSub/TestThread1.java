package primaryWaitingSub;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shichong on 2018/7/26.
 */
public class TestThread1 extends Thread {
    private CountDownLatch countDownLatch;

    public TestThread1 (CountDownLatch countDownLatch){
        this.countDownLatch =countDownLatch;
    }
    public void run(){
        System.out.println(this.getName()+"子线程开始");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"子线程结束");

        //倒数器减1
        countDownLatch.countDown();
    }
}
