package threadMethod;

/**
 * Created by shichong on 2018/6/19.
 *
 * join()方法的使用
 * 阻塞主线程，子线程执行完之后再向下执行
 */
public class TestThread4 {

    public static void main(String[] args) {
        MyThread2 thread2 =new MyThread2("mythread");   //在创建一个新的线程对象的同时给这个线程对象命名为mythread

        thread2.start();    //启动线程

        try {
            thread2.join(); //阻塞主线程，子线程执行完之后再向下执行主线程

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i <= 5; i++) {
            System.out.println("I am main Thread");
        }
    }

/*
I am a	mythread
I am a	mythread
I am a	mythread
I am a	mythread
I am a	mythread
I am a	mythread
I am main Thread
I am main Thread
I am main Thread
I am main Thread
I am main Thread
I am main Thread
 */

    public static class MyThread2 extends Thread{
        MyThread2(String s){
            super(s);
            /**
             * 使用super关键字调用父类的构造方法
             * 父类Thread的其中一个构造方法："public Thread(String name)"
             * 通过这样的构造方法可以给新开辟的线程命名，便于管理线程
             */
        }

        public void run(){
            for (int i = 0; i <= 5; i++) {
                System.out.println("I am a\t"+getName());
                /**
                 * 使用父类Thread里面定义的
                 * public final String getName(),Return this thread's name.
                 */
                try {
                    sleep(1000);    // 让子线程每执行一次就睡眠1s
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

}
