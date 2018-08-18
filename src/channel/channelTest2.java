package channel;

import java.io.*;

/**
 * Created by shichong on 2018/8/18.
 * 实际工程中，往往需要跟多个线程通信，write线程与read线程通信结束后，还需要write线程与其他线程通信。
 *
 */
public class channelTest2 {
    public static class Write extends Thread{
        public PipedOutputStream pos =null;

        //获取线程中的管道输出流
        public PipedOutputStream getPos(){
            pos =new PipedOutputStream();
            return pos;
        }

        //把数据通过管道输出流发送出去
        public void SendData(){
            PrintStream p = new PrintStream(pos);
            for (int i=0;i<10;i++){
                p.println("hello");
                p.flush();
            }
            p.close();
        }

        @Override
        public void run() {
            while (true);//模拟耗时工作
        }
    }

    public static class Read extends Thread{
        public PipedInputStream pis =null;
        public String line ="null";

        //获得线程中管道输出流
        public PipedInputStream getPis(){
            pis =new PipedInputStream();
            return pis;
        }

        //利用管道输入流接收管道数据
        public void ReceiveData(){
            BufferedReader r1 =new BufferedReader(new InputStreamReader(pis));
            try {
                while (line!=null){
                    line=r1.readLine();
                    System.out.println("read:"+line);
                }
                r1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true);//模拟耗时工作
        }
    }

    public static class Other_Thread1 extends Thread{
        public PipedInputStream pis = null;
        public String line = "null";

        //获取线程中的管道输入流

        public PipedInputStream getPis() {
            pis =new PipedInputStream();
            return pis;
        }
        //利用管道输入流接收管道数据
        public void ReceiveData(){
            BufferedReader r = new BufferedReader(new InputStreamReader(pis));
            try {
                while (line!=null){
                    line =r.readLine();
                    System.out.println("Other_Thread1:"+line);
                }
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (true);//模拟耗时操作
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Write write =new Write();
        Read read =new Read();
        Other_Thread1 other =new Other_Thread1();
        //连接两个线程的管道流 ----read和write线程
        write.getPos().connect(read.getPis());
        write.start();
        read.start();
        other.start();
        write.SendData();
        read.ReceiveData();
        Thread.sleep(2000);
        //重新连接两个线程的管道流，----Other_Thread和write线程
        write.getPos().connect(other.getPis());
        write.SendData();
        other.ReceiveData();
    }
}
