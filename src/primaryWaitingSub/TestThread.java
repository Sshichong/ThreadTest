package primaryWaitingSub;

/**
 * Created by shichong on 2018/7/26.
 * 创建一个线程，这个线程执行完成需要5s
 */
public class TestThread extends Thread {
    public void run(){
        System.out.println(this.getName()+"子线程开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName()+"子线程结束");
    }
}
