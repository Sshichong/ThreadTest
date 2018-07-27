package primaryWaitingSub;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by shichong on 2018/7/26.
 * 注意：如果子线程中会有异常，那么countDownLatch.countDown()应该写在finally里面，这样才能保证异常后也能对计数器减1，不会让主线程永远等待。
 * 另外，await()方法还有一个实用的重载方法：public booleanawait(long timeout, TimeUnit unit)，设置超时时间。
 */
public class CountDownLathTest {
    public static void main(String[] args) {
        long start =System.currentTimeMillis();

        //创建一个初始值为5的倒数计数器
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i=0;i<5;i++){
            Thread thread = new TestThread1(countDownLatch);
            thread.start();
        }

        try {
            //阻塞当前线程（主线程）1s，然后执行
            countDownLatch.await(1, TimeUnit.SECONDS);

            //阻塞当前线程（主线程），直到倒数计数器倒数到0
//            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end =System.currentTimeMillis();
        System.out.println("子线程执行时间："+(end - start));
    }
}
/*
Thread-0子线程开始
Thread-2子线程开始
Thread-3子线程开始
Thread-1子线程开始
Thread-4子线程开始
Thread-4子线程结束
Thread-0子线程结束
Thread-1子线程结束
Thread-2子线程结束
Thread-3子线程结束
子线程执行时间：5001
 */