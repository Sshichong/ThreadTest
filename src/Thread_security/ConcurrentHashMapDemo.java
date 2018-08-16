package Thread_security;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shichong on 2018/8/16.
 * TODO HashMap是线程不安全的，ConcurrentHashMap是线程安全的
 */
public class ConcurrentHashMapDemo {
    static Map<String,String> map = new ConcurrentHashMap<String,String>();
    public static class MyThread_S1 extends Thread{
        int start =0;

        public MyThread_S1(int start) {
            this.start =start;
        }

        @Override
        public void run() {
            for (int i= start;i<10000;i+=2){
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread_S1 t1 =new MyThread_S1(0);
        MyThread_S1 t2 =new MyThread_S1(1);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
