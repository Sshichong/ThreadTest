package io;

import java.io.*;

/**
 * Created by shichong on 2018/8/23.
 * 1.创建一个文件向文件中写入数据
 * 2.读取文件中数据并在控制台显示
 */
public class fileStreamTest {
    public static void main(String[] args) throws IOException {
        File f =new File("D:/a.txt");
        FileOutputStream fop =new FileOutputStream(f);
        //构建FileOutputStream对象，文件不存在会自动创建

        OutputStreamWriter writer =new OutputStreamWriter(fop,"UTF-8");
        //构建OutputStreamWriter对象，参数可以指定编码，默认为操作系统默认编码，Windows上为gbk

        writer.append("中文输入");
        //写入缓冲区

        writer.append("\r\n");
        //换行

        writer.append("English");
        //刷新缓冲，写入到文件，如果下面已经没有写入内容了，直接close也会写入

        writer.close();
        //关闭写入流，同时会把缓冲区的内容写入文件，所以上面的注释掉

        fop.close();
        //关闭输出流，释放系统资源

        FileInputStream fip = new FileInputStream(f);
        //构建FileInputStream对象

        InputStreamReader reader = new InputStreamReader(fip,"UTF-8");
        //构建InputStreamReader对象，编码与写入相同

        StringBuffer sb =new StringBuffer();
        while (reader.ready()){
            sb.append((char) reader.read());
            //转成char加到StringBuffer对象中
        }
        System.out.println(sb.toString());
        reader.close();
        //关闭读取流

        fip.close();
        //关闭输入流，释放系统资源
    }
}
