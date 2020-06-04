package com.weibin.nio.channel.lock;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

/**
 * @Desc:
 * @author: zwb
 * @Date: 2019/12/29
 **/
public class FileChannelLockTest_5 {

    public static void main(String[] args) throws Exception {
        // 验证独占锁与共享锁之间是互斥关系
        RandomAccessFile file = new RandomAccessFile("D:\\Channel\\Data\\lock\\c.txt","rw");
        FileChannel channel = file.getChannel();
        System.out.println("获取独占锁开始,当前时间为：" + new Date().toLocaleString());
        FileLock lock = channel.lock(0, 100, false);
        Thread.sleep(5000);
        System.out.println("获取独占锁结束,当前时间为：" + new Date().toLocaleString());
        lock.release();
        System.out.println("释放独占锁,当前时间为：" + new Date().toLocaleString());

    }

}
