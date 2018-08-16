package Thread_JoinAndYield;


/**
 * Created by shichong on 2018/8/14.
 * public final void join() throws InterruptedException  表示无限等待，他会一直阻塞线程，知道目标线程执行完毕
 * public final synchronized void join() throws InterruptedException    给出一个最大等待时间，超过时间如果目标线程还在执行，那么当前线程就“等不及了”，而继续往下执行。
 * 过程：
 * 在main主函数创建线程，并start后。用join方法阻塞主线程（join在哪个线程就阻塞哪个线程）,直到i加到1000000000，新线程执行完了，
 * 继续执行主线程，打印i，这是i已经是100000000
 * 如果没有join方法，两个线程同时进行，打印的i是很小的数或者为0，子线程还没时间让i加到100000000，主线程就已经执行完了。
 */
public class JoinDemo {
    public volatile  static int i =0;
    public static class MyThread_4 extends Thread{
        @Override
        public void run() {
            for (i=0;i<1000000000;i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new MyThread_4();
        t.start();
        t.join();//阻塞当前线程,等待MyThread_4线程。没有此句，打印出的i可能是0或很小的数，有此句总是打印出100000000
        System.out.println(i);
    }
}
