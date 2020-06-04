package com.weibin.nio.channel;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/28
 **/
public class FileChannelWriteSyncTest {

    static FileOutputStream out;
    static FileChannel channel;

    public static void main(String[] args) throws Exception {
        out = new FileOutputStream("D:\\Channel\\Data\\write\\WriteTest_6.txt");
        channel = out.getChannel();
        // 那个程序在最后运行write()方法,文本文件里面就是那个线程写入的数据
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "   start!");
            ByteBuffer buffer = ByteBuffer.wrap("12345".getBytes());
            try {
                channel.write(buffer,0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "   start!");
            ByteBuffer buffer = ByteBuffer.wrap("67890".getBytes());
            try {
                channel.write(buffer,0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3000);
        channel.close();
        out.close();

    }


}
