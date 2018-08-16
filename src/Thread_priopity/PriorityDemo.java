package Thread_priopity;

/**
 * Created by shichong on 2018/8/15.
 * 线程优先级
 * 优先级越高的在竞争资源时更具优势，但是如果运气不好，优先级高的线程也会抢占资源失败
 */
public class PriorityDemo {
    /**
     * 1 - 10 表示线程的优先级
     */
    public final static int MIN_PRIOPITY = 1;
    public final static int MAX_PRIOPITY = 10;

    /**
     * 使用synchronized产生一次资源竞争，目的是让优先级的差异更加明显。
     */
    public static class MyThread_H extends Thread{
        static int count =0;
        @Override
        public void run() {
            while (true){
                synchronized (this){
                    count ++;
                    if(count>100000){
                        System.out.println("HighPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static class MyThread_L extends Thread{
        static int count = 0;

        @Override
        public void run() {
            while (true){
                count ++;
                synchronized (this){
                    if (count>100000){
                        System.out.println("LowPriority is complete");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 =new MyThread_H();
        Thread t2 =new MyThread_L();
        t1.setPriority(Thread.MAX_PRIORITY);//设置优先级
        t2.setPriority(Thread.MIN_PRIORITY);//设置优先级
        t1.start();
        t2.start();
    }
}
