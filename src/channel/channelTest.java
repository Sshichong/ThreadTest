package channel;

import java.io.*;

/**
 * Created by shichong on 2018/8/17.
 * java管道原理：
 * 管道是一个用来在两个实体之间单项数据传输的导管，java中的管道和Linux中的管道一样，本质上管道是一种文件。
 *
 * 管道流特点：
 * 1.管道数据流是单向的，数据只能从一个进程（线程）流向另一个进程（线程），如果要进行双向通信，必须建立两个管道。
 * 2.管道的读数据是一次性操作，数据一旦被读，他就从管道中被抛弃，释放空间以便写更多的数据。
 * 3.当管道输出流write()导致管道缓冲区变满时，管道的write()调用将默认的被阻塞，等待缓冲区的数据被读取。同样的读进程也可能工作的比写进程快。当所有当前进程数据被读取时，管道变空。
 * 当这种情况发生时，一个随后的read()调用将默认被阻塞，等待缓冲区数据，这解决了read()调用返回文件结束的问题
 * 4.管道输出流或者管道输入流的提前关闭，不会影响到对端流。比如输出流提前结束，输入流不会产生异常；输入流的提前结束也不会影响到输出流。
 *
 * Write线程---->管道------>Read线程
 *
 * write线程是输出流，read是输入流
 *
 *
 * 下述为管道通信的实验，实际工程中我们并不会把管道的两端(输出流和输入流)设置为全局可见，这是不安全的，会造成管道泄漏
 */
public class channelTest {
    public static class Write extends Thread{
        public PipedOutputStream pos;
        Write(PipedOutputStream pos){
            this.pos =pos;
        }
        public void run(){
            PrintStream p =new PrintStream(pos);
            for (int i=1;i<10;i++){
                p.println("hello");
                p.flush();
            }
            p.close();//管道输出流输出结束后一定要关闭输出流，只有关闭输出流之后，对端输入流read()才能返回null
        }
    }

    public static class Read extends Thread{
        public PipedInputStream pis;
        public String line ="null";
        Read(PipedInputStream pis){
            this.pis =pis;
        }
        public void run(){
            BufferedReader r = new BufferedReader(new InputStreamReader(pis));
            try {
                while (line!=null){
                    line =r.readLine();
                    System.out.println(getName()+":"+line);
                }
                r.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //创建管道通信流
        PipedOutputStream pos =new PipedOutputStream();
        PipedInputStream pis = new PipedInputStream(pos);
        new Write(pos).start();
        new Read(pis).start();
    }
}
