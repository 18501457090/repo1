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
public class FileChannelLockTest_10 {

    public static void main(String[] args) throws Exception {
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\d.txt","rw");
        FileChannel channel = file.getChannel();
        System.out.println("尝试获取锁定开始,当前时间为：" + new Date().toLocaleString());
        channel.tryLock();
        FileLock fileLock = channel.tryLock(0, 5, false);
        System.out.print("尝试获取锁定结束,当前时间为：" + new Date().toLocaleString() + "获取锁定状态为：");
        System.out.println(fileLock == null ? "未获得锁定" : "获得锁定");
    }

}
