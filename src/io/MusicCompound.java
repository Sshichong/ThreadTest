package io;

import java.io.*;

/**
 * Created by shichong on 2018/8/24.
 * 使用FileInputStream输入两个音频
 * 使用FileInputStream.skip跳过指定字节长度的音频文件
 * 截取指定长度的音频文件：每次传入8k的内容，使用count记录次数，截取2MB，所以次数为1027*2/8
 * 往同一个输出流FileOutputStream中输出音频并生成文件，实现音频混合
 */
public class MusicCompound {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream =null;
        FileInputStream fileInputStream = null;
        String fileNames[] ={"D:/test/示例歌曲/我只在乎你.mp3","D:/test/示例歌曲/星月神话.mp3"};

        //设置byte数组，每次往输出流中传入8k的内容
        byte by[] = new byte[1024*8];

        try {
            fileOutputStream = new FileOutputStream("D:/test/示例歌曲/合并.mp3");
            for (int i=0;i<2;i++){
                int count=0;
                fileInputStream =new FileInputStream(fileNames[i]);
                //跳过前面3M的内容
                fileInputStream.skip(1024*1024*8);
                InputStreamReader reader = new InputStreamReader(fileInputStream);
                while (reader.ready()){
                    fileOutputStream.write(by);
                    count++;
                    System.out.println(count);
                    //要截取中间2MB的内容，每次输入8k的内容，所以要输入的次数是1024*2/8
                    if (count==1024*2/8){
                        break;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
