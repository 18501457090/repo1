package com.weibin.nio.channel.lock;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest {

    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\a.txt","rw");
        FileChannel channel = raf.getChannel();
        System.out.println("A begin ");
        channel.lock(1,2,false);
        System.out.println("A end");
        Thread.sleep(Integer.MAX_VALUE);
        channel.close();
        raf.close();
    }

}
