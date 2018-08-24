package io;

import java.io.File;
import java.io.IOException;

/**
 * Created by shichong on 2018/8/23.
 * 创建目录和文件
 * 创建目录mkdir()，创建的前一级路径必须存在
 * 创建文件createNewFile()，创建的前一级路径必须存在
 */
public class createDir {
    public static void main(String[] args) throws IOException {
//        String dirname = "/scccccccccccccccccc/1/2/3";
//        String dirname ="D:/tmp/user/java/bin";
        File d =new File("D:/test/a2.txt");
        boolean flag=false;
        flag =d.createNewFile(); //创建文件，前提是路径必须存在
        System.out.println(flag);

        boolean flag1=false;
        File d1 =new File("D:/scccccccccc/scccccc/sccc/scc/scc");
        //现在创建目录
      flag1= d1.mkdir();//前提是 前一级目录必须存在
        System.out.println(flag1);
    }
}
