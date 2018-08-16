package Concurrency;

/**
 * Created by shichong on 2018/8/13.
 * public final void wait() throws InterruptException
 * public final native void notify()
 * 等待(wait)和通知(notify)
 */
public class second {
    final static Object object = new Object();

    public static class MyThread_1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() +" T1 start");
                try {
                    System.out.println(System.currentTimeMillis()+" T1 wait");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis()+" T1 end");
            }
        }
    }

    public static class MyThread_2 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + " T2 start and notify");
                object.notify();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void main(String[] args) {
        Thread t1 = new MyThread_1();
        Thread t2 = new MyThread_2();
        t1.start();
        t2.start();


    }

}
/*
1534150612974 T1 start
1534150612974 T1 wait
1534150612974 T2 start and notify
1534150614974 T1 end

开启了两个线程t1和t2。t1执行了object.wait()方法。注意，在wait方法执行前，t1申请了object对象锁。因此在执行object.wait()时，他说持有锁的。
Wait()方法执行后，t1会进行等待，并且释放object对象的锁。t2在执行notify之前也会获得object对象锁，在notify执行后释放object对象的锁。

主线程，t1，t2同时执行。t1执行wait之后释放对象锁，t2执行notify之后释放对象锁并通知t1在t2执行之后可以执行
 */