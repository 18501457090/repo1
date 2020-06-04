package com.weibin.nio.channel.lock;
import	java.util.Date;
import	java.nio.ByteBuffer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelForceTest {

    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Channel\\Data\\lock\\e.txt");
        if (file.exists()){
            file.delete();
        } else {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file,true);
        FileChannel channel = out.getChannel();
        System.out.println("未强制刷新到内存写入开始时间：" + new Date().toLocaleString());
        for (int i = 0; i < 500000; i++){
            channel.write(ByteBuffer.wrap("abcdefg\r\n".getBytes()));
        }
        System.out.println("未强制刷新到内存写入结束时间：" + new Date().toLocaleString());
        channel.close();
        out.close();
    }

}
