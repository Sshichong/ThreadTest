package Volatile;

/**
 * Created by shichong on 2018/8/14.
 * volatile修饰，可保证可见性，原子性。
 * 过程：
 * main主函数新建线程之后，因为ready是false，Number为1，在主线程睡眠的2s会一直打印1，
 * 当休眠过后，Number改为100，ready还没改为true时，线程会打印100.
 * 当ready改为true时，不打印Number
 */
public class VolatileDemo {
    static volatile boolean ready=false;
     static volatile  int number=1;
    public  static class MyThread_5 extends Thread{
        @Override
        public void run() {
            while (!ready){
                System.out.println(number);
            }
        }
    }

    public  static void main(String[] args) throws InterruptedException {

        new MyThread_5().start();
        Thread.sleep(2000);
        number =100;
        ready =true;

    }
}
