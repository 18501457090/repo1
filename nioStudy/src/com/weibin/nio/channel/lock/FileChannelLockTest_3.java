package com.weibin.nio.channel.lock;
import	java.util.Date;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_3 {


    public static void main(String[] args) throws Exception {
        // 验证共享锁与独占锁之间是互斥关系
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\c.txt","rw");
        FileChannel channel = file.getChannel();
        FileLock lock = channel.lock(0, Long.MAX_VALUE, true);
        Thread.sleep(6000);
        System.out.println("共享锁开始释放,当前时间为：" + new Date().toLocaleString());
        lock.release();
    }

}
