package createThreadway; /**
 * Created by shichong on 2018/6/19.
 * 程序执行到t.start()后开辟了一条新的线程，主线程将继续向下执行。
 * 这条线程是run()方法执行的线程，run()方法和main()方法是交替着执行，或者说叫并行执行
 */

/**
 * 线程创建与启动的第一种方法：使用实现Runnable接口创建和启动新线程，开辟一个新的线程来调用run方法
 */
public class TestThread1 {
    public static void main(String[] args) {
        Runner1 r1 = new Runner1(); // new一个线程类对象出来
//        r1.run();   这个称为方法调用，方法调用的执行是等于run()；方法执行完之后才会执行main()方法

        Thread t=new Thread(r1);    //要启动一个新的线程就必须new一个thread对象出来，这里使用Thread(Runnable target)这个构造方法

        t.start();  //启动新开辟的线程，新线程执行的是run()方法，新线程与主线程会一起并行执行
        for (int i = 0; i < 10; i++) {
            System.out.println("maintheod:"+i);
        }

    }

    /**
    * 定义一个类实现Runnable接口，实现Runnable接口就表示这个类是一个线程类
    */
    public static class Runner1 implements Runnable{
        public void run(){
            for (int i=0;i<10;i++){
                System.out.println("Runner1:"+i);
            }
        }
    }
}
