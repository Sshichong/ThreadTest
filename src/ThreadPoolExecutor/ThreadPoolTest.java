package ThreadPoolExecutor;

/**
 * Created by shichong on 2018/7/31.
 * 实现Runnable接口，创建一个线程
 */
public class ThreadPoolTest implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
