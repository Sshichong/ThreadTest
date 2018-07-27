package primaryWaitingSub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shichong on 2018/7/26.
 * 用list的方法使5个线程并发，主线程等待5个子线程执行结束以后再执行
 */
public class primaryWaitingMulSubConcurrency {
    public static void main(String[] args) {
        long start  = System.currentTimeMillis();
        List<Thread> list =new ArrayList<Thread>();

        for (int i=0;i<5;i++){
            Thread thread =new TestThread();
            thread.start();
            list.add(thread);
        }

        try {
            for (Thread thread: list
                 ) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("子线程执行时间："+(end - start));
    }
}

/*
Thread-0子线程开始
Thread-4子线程开始
Thread-3子线程开始
Thread-2子线程开始
Thread-1子线程开始
Thread-0子线程结束
Thread-2子线程结束
Thread-1子线程结束
Thread-4子线程结束
Thread-3子线程结束
子线程执行时间：5002
 */