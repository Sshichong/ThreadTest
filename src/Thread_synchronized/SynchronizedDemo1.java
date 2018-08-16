package Thread_synchronized;

/**
 * Created by shichong on 2018/8/16.
 * TODO 对对象中的方法加锁
 *
 * synchronized修饰的方法一定要用static修饰（声明为静态方法），否则每创建一个线程就创建了一个increase方法。
 * 声明为静态方法后，无论创建多少个线程都只创建一个increase方法。
 *
 * 除了用于线程同步，确保线程安全之外，synchronized还可以确保线程之间的可见性，有序性。
 * 从可见性角度上讲，synchronized完全可以代替volatile的功能，只是没有那么方便。
 * 从有序性角度上讲，synchronized每一次只有一个线程可以访问同步块，因此，无论同步块内的代码如何被乱序执行，只要保证串行语义一致，那么执行结果总是一样。
 * 被synchronized限制的多个线程是串行执行的
 *
 */
public class SynchronizedDemo1 {
    static int i =0;
    public static class MyThread_Write1 extends Thread{
          public synchronized static void increase(){}{
              for (int j=0;j<10000;j++) {
                  i++;
              }
        }
        @Override
        public void run() {
                increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread_Write1 t1 =new MyThread_Write1();
        MyThread_Write1 t2 =new MyThread_Write1();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("i:"+i);

    }
}
