package threadMethod;

import java.util.Date;

/**
 * Created by shichong on 2018/6/19.
 *
 * sleep()方法的使用
 * 在哪个线程里面调用sleep()方法就让哪个线程睡眠
 *
 */
public class TestThread3 {
    public static void main(String[] args) {
        MyThread thread=new MyThread();
        thread.start(); //调用start()方法启动新开辟线程

        try {
            /**
             * Thread.sleep(10000);
             * sleep()方法是在Thread类里面声明的一个静态方法，因此可以使用Thread.sleep()的格式进行调用
             *
             * MyThread.sleep(10000);
             * MyThread类也继承了Thread类，自然也继承了sleep()方法，所以也可以使用MyThread.sleep(10000)来进行调用
             *
             * 静态方法的调用可以直接使用"类型.静态方法名"或者"对象的引用.静态方法名"
             */
            MyThread.sleep(10000);
            System.out.println("主进程睡眠了10秒后再次启动了！");
            /**
             * 在main()方法里面调用另外一个类的静态方法时，需要使用"静态方法所在的类.静态方法名"这种方式来调用
             *
             * 这里让主线程睡眠10s
             * 在哪个线程里面调用sleep()方法就让哪个线程睡眠，所以现在主线程睡眠了
             */
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /**thread.interrupt()； 使用interrupt()方法去结束掉一个进程的执行不是一个很好的方法
         *
         * 当发生InterruptedException时，直接把循环条件设置为false即可退出死循环
         * 继而结束掉子进程的执行，是一种较好的结束子线程的做法
         *
         * 调用interrupt()方法把正在运行的线程打断，相当于是主线程一盆凉水泼上去把正在执行的分线程打断
         * 分线程打断会抛InterruptException异常，这样就会执行return语句返回，结束掉线程的执行
         * 所以这里的分线程在执行完10s之后就结束掉了线程的执行
         */

         thread.flag=false;

    }

    public static class MyThread extends Thread{
        boolean flag =true; //定义一个标记，用来控制循环条件

        public void run(){
            /**
             * 注意：这里不能再run()方法后直接写throw Exception来抛异常
             * 因为现在是要重写从Thread类继承而来的run()方法，重写方法不能抛出比被重写的方法的不同的异常
             * 所以这里只能写try...catch()来捕获异常
             */
            while (flag){
                System.out.println("===========  "+new Date().toString()+"  ==============");

                try {
                    /**
                     * 静态方法的调用格式一般为"类名.方法名"的格式去调用，在本类中声明的静态方法调用时直接写静态方法名即可，用"类名.方法名"也是没错的
                     *
                     * MyThread.sleep(); 使用"类名.方法名"的格式去调用属于本类的静态方法
                     */
                    sleep(1000);
                    /**
                     * 如果睡眠被打断就会抛出InterruptException异常
                     *
                     * 这里让这个新开辟的线程每隔一秒睡眠一次，然后睡眠一秒后再次启动该线程
                     * 这里在一个死循环里面每隔一秒启动一次线程，每一秒打印出当前的系统时间
                     */
                } catch (InterruptedException e) {
                    /**
                     * 睡眠时一盘冷水泼过来可能打断睡眠
                     * 因此让正在运行线程被一些意外的原因中断的时候有可能会打扰中断(InterruptException)的异常
                     *
                     * 线程中断后就返回，相当于结束线程
                     */
                    return;
                }
            }
        }
    }
}
