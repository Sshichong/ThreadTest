package primaryWaitingSub;

/**
 * Created by shichong on 2018/7/26.
 * 由于thread.join()阻塞了主线程继续执行，导致for循环一次就需要等待一个子线程执行完成，而下一个子线程不能立即start()，5个子线程不能并发
 */
public class primarWaitingMulSub {
    public static void main(String[] args) {
        long start =System.currentTimeMillis();

        for (int i=0;i<5;i++){
            Thread thread =new TestThread();
            thread.start();

            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("子线程执行时间："+(end - start));
    }
}

/*
Thread-0子线程开始
Thread-0子线程结束
Thread-1子线程开始
Thread-1子线程结束
Thread-2子线程开始
Thread-2子线程结束
Thread-3子线程开始
Thread-3子线程结束
Thread-4子线程开始
Thread-4子线程结束
子线程执行时长：25000
 */