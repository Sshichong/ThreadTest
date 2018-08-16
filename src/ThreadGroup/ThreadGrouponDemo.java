package ThreadGroup;

/**
 * Created by shichong on 2018/8/14.
 * 线程组
 * 构造方法：
 * ThreadGroup(String name)：以指定线程组名字来创建新线程组
 * ThreadGroup(ThreadGroup parent,String name)：以指定的名字、指定的父线程组来创建一个新线程组。
 * 常用方法：
 * int activeCount()：获取线程组中活动线程的数量
 * interrupt()：中断线程组中所有线程
 *  isDaemon()：是否为后台线程组
 *  setDaemon(boolean daemon)：设置为后台线程组
 *  setMaxPriority(int pri)：设置线程组的最高优先级
 */
public class ThreadGrouponDemo {
    public static class MyThread_6 extends Thread{
        public MyThread_6(String name) {
            super(name);
        }

        public MyThread_6(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            System.out.println("正在运行："+getName());
        }
    }

    public static void main(String[] args) {
        //创建线程组
        ThreadGroup tGroup = new ThreadGroup("MyThread_Group");
        MyThread_6 t1 =new MyThread_6(tGroup,"t1");
        MyThread_6 t2 =new MyThread_6(tGroup,"t2" );
        t1.start();
        t2.start();
        System.out.println("线程组中活动线程的数量:"+tGroup.activeCount());
        //list()方法打印线程组中的线程信息
        System.out.println("线程信息：");
        tGroup.list();


    }
}
