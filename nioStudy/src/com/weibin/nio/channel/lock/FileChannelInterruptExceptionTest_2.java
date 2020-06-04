package com.weibin.nio.channel.lock;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelInterruptExceptionTest_2 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        System.out.println("A Begin!");
        channel.lock(0,2,false);
        System.out.println("A End!");
        Thread.sleep(20000);
        channel.close();
        raf.close();
    }

}
