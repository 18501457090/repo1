package com.weibin.nio.channel.lock;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelForceTest_1 {

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Channel\\Data\\lock\\e.txt");
        if (file.exists()){
            file.delete();
        } else {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file,true);
        FileChannel channel = out.getChannel();
        System.out.println("强制刷新到内存写入开始时间：" + new Date().toLocaleString());
        for (int i = 0; i < 500000; i++){
            channel.write(ByteBuffer.wrap("abcdefg\r\n".getBytes()));
            channel.force(false); // 强制将写入立即刷新至内存
        }
        System.out.println("强制刷新到内存写入结束时间：" + new Date().toLocaleString());
        channel.close();
        out.close();
    }

}
