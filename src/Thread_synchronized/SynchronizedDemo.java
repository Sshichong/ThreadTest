package Thread_synchronized;

/**
 * Created by shichong on 2018/8/15.
 * synchronized
 * 虽然volatile并不能保证线程安全，他只能保证一个线程修改数据后其他线程能看到这个改动。但是两个线程同时修改一个数据时，依然会产生冲突
 * 因为两个线程同时修改一个变量的时候，一个线程的修改结果会覆盖另一个线程修改的结果
 *
 * 关键字synchronized作用是实现线程之间的同步，他的工作是对同步代码加锁，使得每一次只能有一个线程进入同步块，从而保证线程安全。
 * 用法：
 * 指定加锁对象，对给定对象加锁，进入同步代码前要获得指定的锁
 * 直接作用于实例，相当于对当前实例加锁，进入同步代码前要获得当前实例
 * 直接作用于静态方法，相当于对当前类加锁，进入同步代码前要获得当前类的锁
 *
 * TODO 下面作用于本类
 * 每当线程进入synchronized代码块的时候就会要求请求Synchronized.class的锁。
 * 如果其他线程持有这把锁，那么新到的线程必须等待，保证每次只有一个线程进行i++操作。
 */
public class SynchronizedDemo {
    static int  i=0;
    public static class MyThread_Write extends Thread{
        @Override
        public void run() {
            synchronized (SynchronizedDemo.class){
                for (int j=0;j<100000;j++){
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread_Write t1 =new MyThread_Write();
        MyThread_Write t2 =new MyThread_Write();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
