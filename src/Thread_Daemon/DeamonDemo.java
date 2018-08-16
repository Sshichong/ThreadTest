package Thread_Daemon;

/**
 * Created by shichong on 2018/8/14.
 * 守护线程
 * 守护线程是系统线程，在后台完成一些系统性的服务，垃圾回收线程，JIT线程都试守护线程
 * 用户线程是系统的工作线程，他完成程序应该要完成的业务操作
 * 如果用户线程都全部结束，守护线程要守护的线程不存在了，整个程序就结束了。所以当一个java程序内只有守护线程时，java虚拟机会自动退出。
 */
public class DeamonDemo {
    public static class MyThread_7 extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("I am alive");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread t =new MyThread_7();
        t.setDaemon(true);//将t设置为守护线程，必须要在start()之前设置。否则会有异常。但线程还会执行，把t当做用户线程执行，打印会一直执行。
        t.start();
        Thread.sleep(2000);//打印将在两秒后停下，因为t要守护的主线程休眠两秒后结束。
    }

}
