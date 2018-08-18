package channel;

import java.io.*;

/**
 * Created by shichong on 2018/8/18.
 * 两个线程之间的通信
 */
public class cannelTest1 {
    public static class Write extends Thread{
        public PipedOutputStream pos=null;


        //获取线程中的管道输出流
        public PipedOutputStream getPos(){
            pos =new PipedOutputStream();
            return pos;
        }

        public void run(){
            PrintStream p =new PrintStream(pos);
            for (int i=0;i<1000;i++){
                p.println("hello");
                p.flush();
            }
            p.close();
        }
    }

    public static class Read extends Thread{
        public PipedInputStream pis =null;
        public String line ="null";


        //获取线程中管道输入流
        public PipedInputStream getPis(){
            pis =new PipedInputStream();
            return pis;
        }

        public void run(){
            BufferedReader r = new BufferedReader(new InputStreamReader(pis));
            try {
                while (line!=null){
                    line =r.readLine();
                    System.out.println("read:"+line);
                }
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

   /* public static class Other_Thread extends Thread{
        public PipedInputStream pis;
        public String line ="null";
        Other_Thread(PipedInputStream pis){
            this.pis =pis;
        }
        public void run(){
            BufferedReader r = new BufferedReader(new InputStreamReader(pis));
            try {
                while (line!=null){
                    line =r.readLine();
                    System.out.println("Other_Thread:"+line);
                }
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/

    public static void main(String[] args) throws IOException {
       Write write =new Write();
       Read read =new Read();

       //连接两个线程的管道流
        write.getPos().connect(read.getPis());
        write.start();
        read.start();

    }
}
