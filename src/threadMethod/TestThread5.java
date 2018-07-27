package threadMethod;

/**
 * Created by shichong on 2018/6/19.
 * yield方法的使用
 * 让出线程让另一个线程执行
 */
public class TestThread5 {
    public static void main(String[] args) {
        MyThread3 t1=new MyThread3("t1");
        /**
         * 同事开辟两条子线程t1，t2，t1和t2执行的都是run()方法
         * 这个程序执行过程中总共有3个线程在并行执行，分别为子线程t1，t2以及主线程
         */
        MyThread3 t2=new MyThread3("t2");
        t1.start(); //启动子线程
        t2.start(); //启动子线程
        for (int i = 0; i <=5; i++) {
            System.out.println("I am main Thread");
        }
    }



    public static class MyThread3 extends Thread{
        MyThread3(String s){
            super(s);
        }

        public  void run(){
            for (int i = 1; i <=5; i++) {
                System.out.println(getName()+":"+i);
                if (i%2==0){
                    yield();
                    /**
                     * 当执行到i能被2整除时，当前执行的线程就让出来让另一个在执行run()方法的线程来优先
                     *
                     * 在程序中可以看到
                     * 线程t1执行到(i%2==0)次时就会让出线程让t2线程来优先执行
                     * 而线程t2执行到(i%2==0)次时也会让出线程给t1线程优先执行
                     */
                }
            }
        }
    }

}
