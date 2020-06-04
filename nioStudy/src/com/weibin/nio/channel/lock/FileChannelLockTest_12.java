package com.weibin.nio.channel.lock;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_12 {


    public static void main(String[] args) throws Exception {
        RandomAccessFile raf = new RandomAccessFile("D:\\Channel\\Data\\lock\\d.txt","rw");
        FileChannel channel = raf.getChannel();
        FileLock lock = channel.lock(1, 10, true);
        System.out.println(lock.overlaps(2,3));
        lock.close();
        raf.close();
    }
}
