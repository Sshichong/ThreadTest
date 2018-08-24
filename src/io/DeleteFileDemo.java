package io;

import java.io.File;

/**
 * Created by shichong on 2018/8/24.
 * 删除文件可以使用java.io.File.delete()方法
 * 下面删除D:/test/test1目录，在删除前保证test1中为空，才能删除
 *
 */
public class DeleteFileDemo {
    public static void main(String[] args) {
        //这里修改为自己的测试目录
        File folder =new File("D:/test/test1");
        deleteFolder(folder);
    }


    //删除文件及目录
    public static void deleteFolder(File folder){
        File []files =folder.listFiles();
       if (files!=null){
           for (File f:files){
               if (f.isDirectory()){
                   deleteFolder(f);
               }else {
                   f.delete();
               }
           }
       }
       folder.delete();
    }
}
