package primaryWaitingSub;

/**
 * Created by shichong on 2018/7/26.
 * 主线程不等待子线程
 */
public class primaryUnWaitingOneSub {
    public static void main(String[] args) {
        long start  = System.currentTimeMillis();

        Thread thread =new TestThread();

        thread.start();

        long end = System.currentTimeMillis();

        System.out.println("子线程执行时间："+(end - start));
    }
}

/*
子线程执行时长：0
Thread-0子线程开始
Thread-0子线程结束
 */