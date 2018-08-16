package Thread_security;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by shichong on 2018/8/16.
 * TODO ArrayList是线程不安全的，Vector是线程安全的。
 * 抛出异常是因为ArrayList在扩容过程中，内部一致性被破坏，但由于没有锁的保护，另外一个线程访问到了不一致多的内部状态，导致出现越界问题。
 * ArrayList小于200000是因为多个线程对同一位置进行赋值导致的。
 * 在线程中用Vector代替ArrayList
 */
public class VectorSecurity {
    static Vector<Integer> al = new Vector<Integer>(10);
    public static class MyThread_S extends Thread{
        @Override
        public void run() {
            for (int i =0;i<100000;i++){
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread_S t1= new MyThread_S();
        MyThread_S t2 = new MyThread_S();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());

    }
}
