package com.weibin.nio.channel.lock;
import java.nio.channels.FileLock;
import	java.util.Date;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_7 {

    public static void main(String[] args) throws Exception {
        // 测试独占锁与独占锁之间是互斥关系
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\d.txt","rw");
        FileChannel channel = file.getChannel();
        System.out.println("A 获取独占锁开始,当前时间为：" + new Date().toLocaleString());
        FileLock lock = channel.lock(0, 100, false);
        Thread.sleep(5000);
        lock.release();
        System.out.println("A 释放独占锁,当前时间为：" + new Date().toLocaleString());
        channel.close();
        file.close();
    }

}
