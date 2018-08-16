package Concurrency;

/**
 * Created by shichong on 2018/8/13.
 * 如果在循环体中出现了wait()或者sleep()这样操作的时候，中断可能会被忽略。
 * Thread.sleep()方法会让当前线程休眠若干时间，他会抛出一个interruptException中断异常。interruptException不是运行时异常，也就是程序必须捕获并处理他。当线程在休眠时，如果被中断，
 * 这个异常就会产生。
 * public void Thread.interrupt()   //中断线程
 * Public void boolean Thread.isInterrupted()   //判断线程是否被中断
 * Public static boolean Thread.interrupted()   //判断是否被中断，并请除当前中断状态
 */
public class first {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 =new MyThread();
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();//被忽略
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.println("Thread running");
            if (Thread.currentThread().isInterrupted()){
                System.out.println("interrupt");
                break;
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("when sleep interrupt");
                Thread.currentThread().interrupt();
            }
            System.out.println("Thread end");
        }
    }
}

