package com.weibin.nio.channel.filechannel;
import	java.util.concurrent.Executors;
import	java.util.concurrent.ExecutorService;
import java.io.File;
import java.io.FileNotFoundException;
import	java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2020/3/30
 **/
public class FileChannelLockDemo {

    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Channel\\Data\\FileChannelData\\a.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");
        FileChannel channel = raf.getChannel();
        FileLock lock = channel.lock(0, 10, false);
        boolean valid = lock.isValid();
        System.out.println("valid > " + valid);
        FileLock lock1 = channel.lock(0, 100, false);

    }


}
