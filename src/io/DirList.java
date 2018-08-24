package io;

import java.io.File;

/**
 * Created by shichong on 2018/8/23.
 * 读取目录
 * 调用list()方法，来提取他包含的文件和文件夹列表
 *
 */
public class DirList {
    public static void main(String[] args) {
        String dirname ="D:/test/test1";
        File f1 = new File(dirname);
        if (f1.isDirectory()){
            System.out.println("目录 "+dirname);
            String s[] =f1.list();
            for (int i=0;i<s.length;i++){
//                System.out.println(s[i]);
                File f =new File(dirname+"/"+s[i]);
                if (f.isDirectory()){
                    System.out.println(s[i]+"是一个目录");
                }else{
                    System.out.println(s[i]+"是一个文件");
                }
            }
        }else{
            System.out.println(dirname+" 是不一个目录");
        }
    }
}
