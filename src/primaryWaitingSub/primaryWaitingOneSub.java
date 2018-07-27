package primaryWaitingSub;

/**
 * Created by shichong on 2018/7/26.
 * 主线程等待一个子线程
 * join()方法
 * join()方法会阻塞主线程继续向下执行
 * 注意：join()要在start()方法之后调用。
 */
public class primaryWaitingOneSub {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread thread = new TestThread();
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("子线程执行时长："+(end -  start));
    }
}

/*
Thread-0子线程开始
Thread-0子线程结束
子线程执行时长：5000
 */