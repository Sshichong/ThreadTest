package createThreadway; /**
 * Created by shichong on 2018/6/19.
 * 继承Thread类，并重写其run()方法创建和启动新的线程
 */

/**
 * 线程创建与启动的第二种方法：定义Thread的子类并实现run()方法
 */
public class TestThread2 {
    public static void main(String[] args) {
        Runner2 r2=new Runner2();
        r2.start(); // 调用start()方法启动新开辟的线程

        for (int i = 0; i < 10; i++) {
            System.out.println("maintheod:"+i);
        }
    }

    /**
     * Runner2类从Thread类继承
     * 通过实例化Runner2类的对象就可以开辟一个新的线程
     * 调用从Thread类继承来的start()方法就可以启动新开辟的线程
     */
    public static class Runner2 extends Thread{
        public void run(){  //重写run()方法
            for (int i = 0; i < 10; i++) {
                System.out.println("Runner2:"+i);
            }
        }
    }
}
